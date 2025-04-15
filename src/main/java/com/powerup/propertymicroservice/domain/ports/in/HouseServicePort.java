package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.math.BigDecimal;

public interface HouseServicePort {
    
    void save(HouseModel houseModel);
    PageInfo<HouseModel> getHouses(
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
