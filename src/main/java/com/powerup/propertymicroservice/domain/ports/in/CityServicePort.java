package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CityModel;

public interface CityServicePort {
    
    void save(CityModel cityModel);
}
