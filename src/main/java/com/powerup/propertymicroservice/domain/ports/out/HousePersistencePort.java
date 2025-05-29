package com.powerup.propertymicroservice.domain.ports.out;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

public interface HousePersistencePort {

    void save(HouseModel houseModel);

    List<HouseModel> findHousesByActivePublicationDate(LocalDate date);

    PageInfo<HouseModel> getHouses(
            Integer page,
            Integer size,
            String sortBy,
            Long categoryId,
            String ubicationSearchText,
            String sortDirection,
            PublicationStatus publicationStatus,
            Long sellerId
    );

    Optional<HouseModel> getHouseById(Long id);

    boolean existByCategoryId(Long id);
}
