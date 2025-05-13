package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.handler.CityHandler;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityHandlerImpl implements CityHandler {
    
    private final CityServicePort cityServicePort;
    @Override
    public List<CityModel> getAllCities(boolean orderAsc) {
        return cityServicePort.getAllCities(orderAsc);
    }
}
