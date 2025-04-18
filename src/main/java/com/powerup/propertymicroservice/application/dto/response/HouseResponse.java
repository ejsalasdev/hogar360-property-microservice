package com.powerup.propertymicroservice.application.dto.response;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record HouseResponse(
        Long id,
        String name,
        String description,
        String category,
        Integer numberOfRooms,
        Integer numberOfBathrooms,
        BigDecimal price,
        String adress,
        String ubication,
        String city,
        String department,
        LocalDate activePublicationDate,
        PublicationStatus publicationStatus,
        LocalDate publicationDate,
        Long sellerId
) {
}
