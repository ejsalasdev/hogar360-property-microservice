package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to save a new ubication with sector, city and department information")
public record SaveUbicationRequest(
        
        @Schema(
            description = "Name of the sector. Must contain only letters and spaces. Maximum 50 characters. This field is required.",
            example = "Centro Histórico",
            maxLength = 50,
            pattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"
        )
        String sector,
        
        @Schema(
            description = "Name of the city. Must contain only letters and spaces. Maximum 50 characters. This field is required.",
            example = "Bogotá",
            maxLength = 50,
            pattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"
        )
        String cityName,
        
        @Schema(
            description = "Name of the department. Must contain only letters and spaces. Maximum 50 characters. This field is optional - if not provided, the system will try to find the department automatically.",
            example = "Cundinamarca",
            maxLength = 50,
            pattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            nullable = true
        )
        String departmentName
) {
}
