package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveUbicationResponse;

public interface UbicationHandler {
    
    SaveUbicationResponse save(SaveUbicationRequest saveUbicationRequest);
}
