package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.HouseEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.HouseRepository;
import com.powerup.propertymicroservice.infrastructure.repositories.specifications.HouseSpecification;
import com.powerup.propertymicroservice.infrastructure.utils.sort.HouseSortHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HousePersistenceAdapter implements HousePersistencePort {
    
    private final HouseRepository houseRepository;
    private final HouseEntityMapper houseEntityMapper;
    private final HouseSortHelper houseSortHelper;
    @Override
    public void save(HouseModel houseModel) {
        HouseEntity houseEntity = houseEntityMapper.modelToEntity(houseModel);
        houseRepository.save(houseEntity);
    }

    @Override
    public List<HouseModel> findHousesByActivePublicationDate(LocalDate date) {
        List<HouseEntity> houseEntities = houseRepository.findByActivePublicationDate(date);
        return houseEntities.stream()
                .map(houseEntityMapper::entityToModel)
                .toList();
    }

    @Override
    public PageInfo<HouseModel> getHouses(
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
    ) {
        Sort sort = houseSortHelper.createSort(sortBy, sortDirection);

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<HouseEntity> spec = HouseSpecification.withFilters(
                categoryId,
                ubicationId,
                minRooms,
                maxRooms,
                minBathrooms,
                maxBathrooms,
                minPrice,
                maxPrice,
                PublicationStatus.PUBLISHED
        );
        
        Page<HouseEntity> houseEntityPage = houseRepository.findAll(spec, pageable);
        
        List<HouseModel> houses = houseEntityPage.getContent().stream()
                .map(houseEntityMapper::entityToModel)
                .toList();
        
        return new PageInfo<>(
                houses,
                houseEntityPage.getTotalElements(),
                houseEntityPage.getTotalPages(),
                houseEntityPage.getNumber(),
                houseEntityPage.getSize(),
                houseEntityPage.hasNext(),
                houseEntityPage.hasPrevious()
        );
    }

    @Override
    public Optional<HouseModel> getHouseById(Long id) {
        return houseRepository.findById(id).map(houseEntityMapper::entityToModel);
    }
}
