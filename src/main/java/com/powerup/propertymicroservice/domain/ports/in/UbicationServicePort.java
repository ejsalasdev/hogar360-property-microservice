package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.UbicationModel;

public interface UbicationServicePort {
    
    void save(String sector, String cityName);
}
