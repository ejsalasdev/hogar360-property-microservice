package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;

public interface HouseHandler {
    
    SaveHouseResponse save(SaveHouseRequest request);
}
