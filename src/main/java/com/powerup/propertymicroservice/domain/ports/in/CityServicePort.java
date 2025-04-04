package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CityModel;

public interface CityServicePort {
    
    CityModel getCityByName(String name);
    
    CityModel getUniqueCityByName(String cityName);

    CityModel getCityByNameAndDepartmentName(String cityName, String departmentName);
}
