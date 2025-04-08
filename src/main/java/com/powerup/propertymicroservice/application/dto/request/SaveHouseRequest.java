package com.powerup.propertymicroservice.application.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SaveHouseRequest(
        
        String name,
        String description,
        String category,
        Integer numberOfRooms,
        BigDecimal numberOfBathrooms,
        BigDecimal price,
        String ubication,
        String adress,
        LocalDate activePublicationDate
) {
}
