package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SaveDepartmentRequest(
        @Schema(description = "Name of the department.", example = "Cundinamarca", maxLength = 50, nullable = false) String name,
        @Schema(description = "Description of the deparment.", example = "Units in buildings, for rent.", maxLength = 90) String description) {
}
