package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.CityModel;

import java.util.Optional;

public interface CityPersistencePort {

    Optional<CityModel> getCityById(Long id);
    Optional<CityModel> getCityByName(String name);
}
