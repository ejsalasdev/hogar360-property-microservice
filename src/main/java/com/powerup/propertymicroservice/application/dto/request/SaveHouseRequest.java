package com.powerup.propertymicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Request to save a new house property")
public record SaveHouseRequest(
        
        @Schema(
            description = "Name of the house property. Must contain only letters and spaces. Maximum 50 characters.",
            example = "Casa Familiar Moderna",
            maxLength = 50,
            pattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"
        )
        String name,
        
        @Schema(
            description = "Detailed description of the house property. Can contain letters, numbers and spaces. Maximum 300 characters.",
            example = "Amplia casa familiar con jardín y piscina ubicada en zona residencial tranquila",
            maxLength = 300,
            pattern = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$"
        )
        String description,
        
        @Schema(
            description = "ID of the property category (apartment, house, etc.). Must be a positive number.",
            example = "1",
            minimum = "1"
        )
        Long categoryId,
        
        @Schema(
            description = "Number of rooms in the house. Cannot be negative.",
            example = "3",
            minimum = "0"
        )
        Integer numberOfRooms,
        
        @Schema(
            description = "Number of bathrooms in the house. Cannot be negative.",
            example = "2",
            minimum = "0"
        )
        Integer numberOfBathrooms,
        
        @Schema(
            description = "Price of the house property in the local currency. Cannot be negative.",
            example = "250000.00",
            minimum = "0"
        )
        BigDecimal price,
        
        @Schema(
            description = "ID of the location/ubication where the house is located. Must be a positive number.",
            example = "1",
            minimum = "1"
        )
        Long ubicationId,
        
        @Schema(
            description = "Physical address of the house property. Can contain letters, numbers, spaces and # symbol.",
            example = "Avenida Principal 456 #12-34",
            pattern = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]*#?[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]*$"
        )
        String address,
        
        @Schema(
            description = "Date when the house publication should become active. Must be today or up to 30 days in the future.",
            example = "2025-06-15",
            implementation = String.class,
            pattern = "yyyy-MM-dd"
        )
        LocalDate activePublicationDate
) {
}
