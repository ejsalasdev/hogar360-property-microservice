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
        BigDecimal numberOfBathrooms,
        BigDecimal price,
        String ubication,
        String adress,
        LocalDate activePublicationDate,
        PublicationStatus publicationStatus,
        LocalDate publicationDate
) {
}
