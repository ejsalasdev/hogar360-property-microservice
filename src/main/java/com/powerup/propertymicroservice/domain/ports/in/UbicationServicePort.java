package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.UbicationModel;

public interface UbicationServicePort {
    
    void save(UbicationModel ubicationModel);
}
