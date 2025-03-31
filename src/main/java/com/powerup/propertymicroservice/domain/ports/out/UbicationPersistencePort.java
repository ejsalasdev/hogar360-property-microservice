package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.UbicationModel;

import java.util.Optional;

public interface UbicationPersistencePort {
    
    void save(UbicationModel ubicationModel);
    Optional<UbicationModel> getUbicationBySectorAndCityId(String sector, Long cityId);
}
