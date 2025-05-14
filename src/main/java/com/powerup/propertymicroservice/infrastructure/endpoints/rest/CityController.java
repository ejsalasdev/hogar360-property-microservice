package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.response.CityResponse;
import com.powerup.propertymicroservice.application.handler.CityHandler;
import com.powerup.propertymicroservice.infrastructure.exceptionshandler.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
@Tag(name = "City", description = "Operations related to Cities")
public class CityController {

    private final CityHandler cityHandler;

    @GetMapping("/departments/{departmentId}")
    @Operation(summary = "Get cities by department", description = "Retrieves a list of cities filtered by department ID with optional sorting.")
    @ApiResponse(responseCode = "200", description = "List of cities retrieved successfully.")
    @ApiResponse(responseCode = "400", description = "Invalid sorting parameters.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ExceptionResponse.class)
            ))
    public ResponseEntity<List<CityResponse>> getAllCitiesByDepartmentId(
            @PathVariable @Parameter(description = "ID of the department to filter cities", required = true) Long departmentId,
            @RequestParam(defaultValue = "true") @Parameter(description = "Sort order (true for ascending, false for descending.") boolean orderAsc) {
        return ResponseEntity.ok(cityHandler.getAllCitiesByDepartmentId(departmentId, orderAsc));
    }
}
