package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveDepartmentResponse;
import com.powerup.propertymicroservice.application.handler.UbicationHandler;
import com.powerup.propertymicroservice.application.mappers.UbicationRequestMapper;
import com.powerup.propertymicroservice.application.utils.constants.ApplicationConstants;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UbicationHandlerImpl implements UbicationHandler {
    
    private final UbicationServicePort ubicationServicePort;
    private final UbicationRequestMapper ubicationRequestMapper;


    @Override
    public SaveDepartmentResponse save(SaveUbicationRequest request) {
        UbicationModel ubicationModel = ubicationRequestMapper.requestToModel(request);
        ubicationServicePort.save(ubicationModel, request.cityName());
        return new SaveDepartmentResponse(ApplicationConstants.SAVE_UBICATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
