package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationsExceptionsMessagesConstants;

import java.util.Optional;

public class UbicationUseCase implements UbicationServicePort {

    public final UbicationPersistencePort ubicationPersistencePort;

    public UbicationUseCase(UbicationPersistencePort ubicationPersistencePort) {
        this.ubicationPersistencePort = ubicationPersistencePort;
    }

    @Override
    public void save(UbicationModel ubicationModel) {
        Optional<UbicationModel> ubication = ubicationPersistencePort.getUbicationByname(ubicationModel.getName());
        if (ubication.isPresent()) {
            throw new ElementAlreadyExistsException(UbicationsExceptionsMessagesConstants.UBICATION_EXISTS_EXCEPTION + ubicationModel.getName());
        }
        ubicationPersistencePort.save(ubicationModel);
    }
}
