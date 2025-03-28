package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveCategoryRequest;
import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveCategoryResponse;
import com.powerup.propertymicroservice.application.handler.CategoryHandler;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.infrastructure.exceptionshandler.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryHandler categoryHandler;

    @PostMapping("/")
    @Operation(summary = "Create a new category", description = "Creates a new category with the provided name and description.")
    @ApiResponse(responseCode = "201", description = "Category created successfully.",
            content = @Content(schema = @Schema(implementation = SaveCategoryResponse.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request data.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class),
                    examples = {
                            @ExampleObject(
                                    name = "Name too long",
                                    value = "{\"message\": \"The name of the category can not exceed 50 characters\"}"
                            ),
                            @ExampleObject(
                                    name = "Description too long",
                                    value = "{\"message\": \"The description of the category can not exceed 90 characters\"}"
                            ),
                            @ExampleObject(
                                    name = "Name null or empty",
                                    value = "{\"message\": \"Field 'name' cannot be null or empty\"}"
                            ),
                            @ExampleObject(
                                    name = "Description null or empty",
                                    value = "{\"message\": \"Field 'description' cannot be null or empty\"}"
                            ),
                            @ExampleObject(
                                    name = "Invalid name characters",
                                    value = "{\"message\": \"Category name contains invalid characters. Only letters, numbers, underscore, and space are allowed.\"}"
                            )
                    }
            ))
    @ApiResponse(responseCode = "409", description = "Category with that name already exists.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class),
                    examples = {
                            @ExampleObject(
                                    name = "Category already exists",
                                    value = "{\"message\": \"La categoría con ese nombre ya existe.\"}"
                            )
                    }
            ))
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryHandler.save(request));
    }

    @GetMapping("/")
    @Operation(summary = "Get all categories with pagination", description = "Retrieves a paginated list of categories.")
    @ApiResponse(responseCode = "200", description = "List of categories retrieved successfully.",
            content = @Content(schema = @Schema(implementation = PageInfo.class)))
    @ApiResponse(responseCode = "400", description = "Invalid pagination parameters.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class),
                    examples = {
                            @ExampleObject(
                                    name = "Invalid page number",
                                    value = "{\"message\": \"Page number cannot be negative.\"}"
                            ),
                            @ExampleObject(
                                    name = "Invalid page size",
                                    value = "{\"message\": \"Page size cannot be negative or zero.\"}"
                            ),
                            @ExampleObject(
                                    name = "Page size exceeds maximum allowed",
                                    value = "{\"message\": \"Page size exceeds maximum allowed.\"}"
                            ),
                            @ExampleObject(
                                    name = "Page number is required",
                                    value = "{\"message\": \"Page number is required.\"}"
                            ),
                            @ExampleObject(
                                    name = "Page size is required",
                                    value = "{\"message\": \"Page size is required.\"}"
                            )
                    }
            ))
    public ResponseEntity<PageInfo<CategoryResponse>> getAllCategories(
            @RequestParam(required = false) @Parameter(description = "Page number (starting from 0).") Integer page,
            @RequestParam(required = false) @Parameter(description = "Number of items per page (starting from 1).") Integer size,
            @RequestParam(defaultValue = "true") @Parameter(description = "Sort order (true for ascending, false for descending).") boolean orderAsc) {
        PageInfo<CategoryResponse> categoryPageInfo = categoryHandler.getCategories(page, size, orderAsc);
        return ResponseEntity.ok(categoryPageInfo);
    }

}
