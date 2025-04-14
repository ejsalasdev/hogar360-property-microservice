package com.powerup.propertymicroservice.application.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SaveHouseRequest(
        
        String name,
        String description,
        Long categoryId,
        Integer numberOfRooms,
        Integer numberOfBathrooms,
        BigDecimal price,
        Long ubicationId,
        String address,
        LocalDate activePublicationDate
) {
}
