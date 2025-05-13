package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.powerup.propertymicroservice.application.dto.response.DepartmentResponse;
import com.powerup.propertymicroservice.application.handler.DepartmentHandler;
import com.powerup.propertymicroservice.infrastructure.exceptionshandler.ExceptionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Tag(name = "Department", description = "Operations related to departments")
public class DepartmentController {

    private final DepartmentHandler departmentHandler;

    @GetMapping
    @Operation(summary = "Get all departments", description = "Retrieves a list of all departments with optional sorting.")
    @ApiResponse(responseCode = "200", description = "List of departments retrieved successfully.")
    @ApiResponse(responseCode = "400", description = "Invalid sorting parameters.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class)
            ))
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(
            @RequestParam(defaultValue = "true") @Parameter(description = "Sort order (true for ascending, false for descending).") boolean orderAsc) {
        return ResponseEntity.ok(departmentHandler.getAllDepartments(orderAsc));
    }
}
