package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to save a new property category")
public record SaveCategoryRequest(
        
        @Schema(
            description = "Name of the category. Must contain only letters and spaces. Maximum 50 characters. This field is required.",
            example = "Apartamentos en Venta",
            maxLength = 50,
            pattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"
        )
        String name,
        
        @Schema(
            description = "Description of the category. Can contain letters, numbers and spaces. Maximum 90 characters. This field is required.",
            example = "Unidades habitacionales en edificios disponibles para compra",
            maxLength = 90,
            pattern = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$"
        )
        String description
) {
}
