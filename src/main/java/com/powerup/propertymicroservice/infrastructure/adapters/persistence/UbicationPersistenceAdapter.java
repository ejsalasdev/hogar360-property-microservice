package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.infrastructure.entities.UbicationEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.UbicationEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.UbicationRepository;
import com.powerup.propertymicroservice.infrastructure.utils.validation.UbicationSortHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UbicationPersistenceAdapter implements UbicationPersistencePort {

    private final UbicationRepository ubicationRepository;
    private final UbicationEntityMapper ubicationEntityMapper;
    private final UbicationSortHelper ubicationSortHelper;

    @Override
    public void save(UbicationModel ubicationModel) {
        UbicationEntity ubicationEntity = ubicationEntityMapper.modelToEntity(ubicationModel);
        ubicationRepository.save(ubicationEntity);
    }

    @Override
    public Optional<UbicationModel> getUbicationBySectorAndCityId(String sector, Long cityId) {
        return ubicationRepository.findBySectorAndCityId(sector, cityId)
                .map(ubicationEntityMapper::entityToModel);
    }

    @Override
    public PageInfo<UbicationModel> getUbications(String searchText, Integer page, Integer size, String sortBy, String sortDirection) {
        Sort sort = ubicationSortHelper.createSort(sortBy, sortDirection);       
        
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<UbicationEntity> ubicationEntityPage;

        if (searchText != null && !searchText.trim().isEmpty()) {
            ubicationEntityPage = ubicationRepository.searchUbications(searchText.trim(), pageable);
        } else {
            ubicationEntityPage = ubicationRepository.findAll(pageable);
        }

        List<UbicationModel> ubications = ubicationEntityPage.getContent().stream()
                .map(ubicationEntityMapper::entityToModel)
                .toList();
        
        return new PageInfo<>(
                ubications,
                ubicationEntityPage.getTotalElements(),
                ubicationEntityPage.getTotalPages(),
                ubicationEntityPage.getNumber(),
                ubicationEntityPage.getSize(),
                ubicationEntityPage.hasNext(),
                ubicationEntityPage.hasPrevious()
        );
    }

    @Override
    public Optional<UbicationModel> getCategoryByname(String ubicationName) {
        return ubicationRepository.findByName(ubicationName).map(ubicationEntityMapper::entityToModel);
    }
}
