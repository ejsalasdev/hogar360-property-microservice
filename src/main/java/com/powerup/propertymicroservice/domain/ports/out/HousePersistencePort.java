package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HousePersistencePort {

    void save(HouseModel houseModel);    
    List<HouseModel> findHousesByActivePublicationDate(LocalDate date);
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
            String sortDirection
    );
    
    Optional<HouseModel> getHouseById(Long id);

    boolean existByCategoryId(Long id);
}
