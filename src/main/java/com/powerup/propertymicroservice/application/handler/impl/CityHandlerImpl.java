package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.response.CityResponse;
import com.powerup.propertymicroservice.application.handler.CityHandler;
import com.powerup.propertymicroservice.application.mappers.CityResponseMapper;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityHandlerImpl implements CityHandler {

    private final CityServicePort cityServicePort;
    private final CityResponseMapper cityResponseMapper;

    @Override
    public List<CityResponse> getAllCities(boolean orderAsc) {
        return cityServicePort.getAllCities(orderAsc).stream()
                .map(cityResponseMapper::modelToResponse)
                .toList();
    }
}
