package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAmbiguousNameException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CitiesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.cities.CityValidator;

import java.util.List;
import java.util.Optional;

public class CityUseCase implements CityServicePort {

    private final CityPersistencePort cityPersistencePort;
    private final CityValidator cityValidator;

    public CityUseCase(CityPersistencePort cityPersistencePort, CityValidator cityValidator) {
        this.cityPersistencePort = cityPersistencePort;
        this.cityValidator = cityValidator;
    }
    
    @Override
    public CityModel getCityByName(String name) {
        cityValidator.validateCityName(name);
        Optional<CityModel> city = cityPersistencePort.getCityByName(name);
        if (city.isEmpty()) {
            throw new ElementNotFoundException(String.format(CitiesExceptionsMessagesConstants.CITY_NOT_FOUND_EXCEPTION, name));
        }
        return city.get();
    }

    @Override
    public CityModel getUniqueCityByName(String cityName) {
        List<CityModel> cities = cityPersistencePort.getAllCitiesByName(cityName);
        if (cities.size() == 1) {
            return cities.get(0);
        } else if (cities.size() > 1) {
            throw new ElementAmbiguousNameException(
                    String.format(CitiesExceptionsMessagesConstants.CITY_AMBIGOUS_FOUND_EXCEPTION,
                    cities.size(), cityName
                    ));
        } else {
            throw new ElementNotFoundException(
                    String.format(CitiesExceptionsMessagesConstants.CITY_NOT_FOUND_EXCEPTION,
                            cityName
                    ));
        }
    }

    @Override
    public CityModel getCityByNameAndDepartmentName(String cityName, String departmentName) {
        Optional<CityModel> city = cityPersistencePort.getCityAndDepartmentByName(cityName, departmentName);
        if (city.isEmpty()) {
            throw new ElementNotFoundException(String.format(CitiesExceptionsMessagesConstants.CITY_NOT_FOUND_IN_DEPARTMENT_EXCEPTION, cityName, departmentName));
        }
        return city.get();
    }
}
