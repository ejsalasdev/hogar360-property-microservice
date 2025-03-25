package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.CityModel;

import java.util.Optional;

public interface CityPersistencePort {
    
    void save(CityModel cityModel);
    Optional<CityModel> getCityByName(String cityName);

    Optional<CityModel> getCityByNameAndDepartmentId(String cityName, Long departmentId);
}
