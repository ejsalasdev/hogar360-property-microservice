package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.response.CityResponse;
import com.powerup.propertymicroservice.domain.model.CityModel;

import java.util.List;

public interface CityHandler {
    
    List<CityResponse> getAllCities(boolean orderAsc);
}
