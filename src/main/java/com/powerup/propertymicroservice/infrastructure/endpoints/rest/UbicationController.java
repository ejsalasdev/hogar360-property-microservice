package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveUbicationResponse;
import com.powerup.propertymicroservice.application.dto.response.UbicationResponse;
import com.powerup.propertymicroservice.application.handler.UbicationHandler;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ubication")
@RequiredArgsConstructor
@Tag(name = "Ubication", description = "Operations related to ubication")
public class UbicationController {

    private final UbicationHandler ubicationHandler;

    @Operation(summary = "Create a new ubication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ubication created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SaveUbicationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "Element city not found"),
            @ApiResponse(responseCode = "409", description = "Ubication already exists in the specified city"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/")
    public ResponseEntity<SaveUbicationResponse> save(@RequestBody @Schema(description = "Ubication information to save") SaveUbicationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ubicationHandler.save(request));
    }

    @GetMapping("/")
    @Operation(summary = "Search paginated list of ubications by city or department name, with optional sorting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved paginated list of ubications",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PageInfo.class,
                                    subTypes = {UbicationResponse.class}))),
            @ApiResponse(responseCode = "400", description = "Invalid pagination parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PageInfo<UbicationResponse>> getAllUbications(
            @Parameter(description = "Text to search in city or department name (case-insensitive)")
            @RequestParam(value = "searchText", required = false) String searchText,
            @Parameter(description = "Page number (default: 0)")
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @Parameter(description = "Number of items per page (default: 10)")
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @Parameter(description = "Field to sort by (default: cityName, options: cityName, departmentName)")
            @RequestParam(value = "sortBy", defaultValue = "cityName") String sortBy,
            @Parameter(description = "Sort order (default: true for ascending, false for descending)")
            @RequestParam(value = "orderAsc", defaultValue = "true") boolean orderAsc
    ) {
        PageInfo<UbicationResponse> ubicationPageInfo = ubicationHandler.getUbications(searchText, page, size, sortBy, orderAsc);
        return ResponseEntity.ok(ubicationPageInfo);
    }
}