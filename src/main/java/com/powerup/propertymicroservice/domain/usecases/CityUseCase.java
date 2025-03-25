package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;

import java.util.Optional;

public class CityUseCase implements CityServicePort {

    public final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }


    @Override
    public void save(CityModel cityModel, String departmentName) {
        
    }
}
