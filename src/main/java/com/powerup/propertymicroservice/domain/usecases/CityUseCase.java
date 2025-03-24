package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationsExceptionsMessagesConstants;

import java.util.Optional;

public class CityUseCase implements CityServicePort {

    public final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public void save(CityModel cityModel) {
        Optional<CityModel> city = cityPersistencePort.getCityByName(cityModel.getName());
        if (city.isPresent()) {
            throw new ElementAlreadyExistsException(UbicationsExceptionsMessagesConstants.CITY_EXISTS_EXCEPTION + cityModel.getName());
        }
        cityPersistencePort.save(cityModel);
    }
}
