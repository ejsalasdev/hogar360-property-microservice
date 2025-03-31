package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SaveDepartmentRequest(
        @Schema(description = "Name of the department.", example = "Cundinamarca", maxLength = 50, nullable = false) String name,
        @Schema(description = "Description of the deparment.", example = "Departamento del centro de Colombia rodea la capital Bogota", maxLength = 120) String description) {
}
