package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.CityModel;

import java.util.List;
import java.util.Optional;

public interface CityPersistencePort {
    
    Optional<CityModel> getCityByName(String name);
    List<CityModel> getAllCitiesByName(String name);
    Optional<CityModel> getCityAndDepartmentByName(String cityName, String departmentName);
}
