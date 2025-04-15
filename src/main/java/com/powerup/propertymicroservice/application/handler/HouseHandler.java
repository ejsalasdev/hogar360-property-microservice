package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.HouseResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.math.BigDecimal;

public interface HouseHandler {
    
    SaveHouseResponse save(SaveHouseRequest request);
    PageInfo<HouseResponse> getHouses(
            Integer page,
            Integer size,
            String sortBy,
            Long categoryId,
            Long ubicationId,
            Integer minRooms,
            Integer maxRooms,
            Integer minBathrooms,
            Integer maxBathrooms,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            boolean orderAsc
    );
}
