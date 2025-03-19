package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SaveCategoryRequest(
        @Schema(description = "Name of the category.", example = "Apartments for Rent", maxLength = 50, nullable = false) String name,
        @Schema(description = "Description of the category.", example = "Units in buildings, for rent.", maxLength = 90) String description) {
}
