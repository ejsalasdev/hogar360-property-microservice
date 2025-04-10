package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;
import com.powerup.propertymicroservice.application.handler.HouseHandler;
import com.powerup.propertymicroservice.application.mappers.HouseRequestMapper;
import com.powerup.propertymicroservice.application.utils.constants.ApplicationConstants;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HouseHandlerImpl implements HouseHandler {
    
    private final HouseServicePort houseServicePort;
    private final HouseRequestMapper houseRequestMapper;
    
    @Override
    public SaveHouseResponse save(SaveHouseRequest request) {        
        HouseModel houseModel = houseRequestMapper.requestToModel(request);
        houseServicePort.save(houseModel);
        return new SaveHouseResponse(ApplicationConstants.SAVE_HOUSE_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
