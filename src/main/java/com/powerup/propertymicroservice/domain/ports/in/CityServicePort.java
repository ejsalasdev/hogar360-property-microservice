package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CityModel;

public interface CityServicePort {

    CityModel getUniqueCityByName(String cityName);

    CityModel getCityByNameAndDepartmentName(String cityName, String departmentName);
}
