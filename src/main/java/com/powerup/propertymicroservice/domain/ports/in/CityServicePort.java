package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CityModel;

import java.util.Optional;

public interface CityServicePort {
    
    CityModel getCityByName(String name);
}
