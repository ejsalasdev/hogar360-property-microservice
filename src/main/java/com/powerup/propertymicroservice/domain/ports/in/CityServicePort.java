package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CityModel;
import java.util.List;

public interface CityServicePort {

    CityModel getUniqueCityByName(String cityName);

    CityModel getCityByNameAndDepartmentName(String cityName, String departmentName);

    List<CityModel> getAllCities(boolean orderAsc);
}
