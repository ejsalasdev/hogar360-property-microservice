package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

public interface HouseServicePort {
    
    void save(HouseModel houseModel);
    PageInfo<HouseModel> getHouses(
            Integer page,
            Integer size,
            String sortBy,
            Long categoryId,
            String ubicationSearchText,
            boolean orderAsc
    );
    
    HouseModel getHouseById(Long id);
    
    boolean existsByCategoryId(Long id);
}
