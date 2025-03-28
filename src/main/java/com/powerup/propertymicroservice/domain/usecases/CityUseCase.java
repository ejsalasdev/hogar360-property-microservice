package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CitiesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.cities.CityValidator;

import java.util.Optional;

public class CityUseCase implements CityServicePort {

    private final CityPersistencePort cityPersistencePort;
    private final CityValidator cityValidator;

    public CityUseCase(CityPersistencePort cityPersistencePort, CityValidator cityValidator) {
        this.cityPersistencePort = cityPersistencePort;
        this.cityValidator = cityValidator;
    }
    
    @Override
    public Optional<CityModel> getCityByName(String name) {
        cityValidator.validateCityName(name);
        Optional<CityModel> city = cityPersistencePort.getCityByName(name);
        if (city.isEmpty()) {
            throw new ElementNotFoundException(String.format(CitiesExceptionsMessagesConstants.CITY_NOT_FOUND_EXCEPTION, name));
        }
        return city;
    }
}
