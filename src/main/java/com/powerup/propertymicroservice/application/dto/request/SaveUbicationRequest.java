package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SaveUbicationRequest(
        @Schema(description = "Name of the sector.", example = "Centro", nullable = false) String sector,
        @Schema(description = "Name of the city", example = "Bogota", maxLength = 50) String cityName,
        @Schema(description = "Name of the department (optional)", example = "Cundinamarca", maxLength = 50, nullable = true) String departmentName
) {
}
