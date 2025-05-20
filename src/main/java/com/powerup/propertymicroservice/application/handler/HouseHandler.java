package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.HouseResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

public interface HouseHandler {
    
    SaveHouseResponse save(SaveHouseRequest request);
    PageInfo<HouseResponse> getHouses(
            Integer page,
            Integer size,
            String sortBy,
            Long categoryId,
            String ubicationSearchText,
            boolean orderAsc
    );
    
    HouseResponse getHouseById(Long id);
}
