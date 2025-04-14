package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.util.Optional;

public interface UbicationPersistencePort {
    
    void save(UbicationModel ubicationModel);
    Optional<UbicationModel> getUbicationBySectorAndCityId(String sector, Long cityId);
    PageInfo<UbicationModel> getUbications(String searchText, Integer page, Integer size, String sortBy, String sortDirection);
    Optional<UbicationModel> getUbicationById(Long id);
    
}
