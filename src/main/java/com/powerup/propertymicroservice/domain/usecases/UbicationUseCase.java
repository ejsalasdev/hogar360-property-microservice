package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationExceptionMessagesConstants;

import java.util.Optional;


public class UbicationUseCase implements UbicationServicePort {

    private final UbicationPersistencePort ubicationPersistencePort;
    private final CityServicePort cityServicePort;

    public UbicationUseCase(UbicationPersistencePort ubicationPersistencePort, CityServicePort cityServicePort) {
        this.ubicationPersistencePort = ubicationPersistencePort;
        this.cityServicePort = cityServicePort;
    }

    @Override
    public void save(UbicationModel ubicationModel, String cityName) {
        CityModel city = cityServicePort.getCityByName(cityName)
                .orElseThrow(() -> new ElementNotFoundException(
                        String.format(UbicationExceptionMessagesConstants.UBICATION_NOT_FOUND_EXCEPTION, cityName)
                ));

        Optional<UbicationModel> existingUbication = ubicationPersistencePort
                .getUbicationBySectorAndCityId(ubicationModel.getSector(), city.getId());

        if (existingUbication.isPresent()) {
            throw new ElementAlreadyExistsException(
                    String.format(UbicationExceptionMessagesConstants.UBICATION_ALREADY_EXISTS_EXCEPTION, ubicationModel.getSector(), cityName)
            );
        }

        ubicationModel.setCity(city);
        ubicationPersistencePort.save(ubicationModel);
    }
}
