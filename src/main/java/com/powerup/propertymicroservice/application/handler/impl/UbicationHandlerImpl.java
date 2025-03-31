package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveUbicationResponse;
import com.powerup.propertymicroservice.application.dto.response.UbicationResponse;
import com.powerup.propertymicroservice.application.handler.UbicationHandler;
import com.powerup.propertymicroservice.application.mappers.UbicationRequestMapper;
import com.powerup.propertymicroservice.application.mappers.UbicationResponseMapper;
import com.powerup.propertymicroservice.application.utils.constants.ApplicationConstants;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UbicationHandlerImpl implements UbicationHandler {
    
    private final UbicationServicePort ubicationServicePort;
    private final UbicationRequestMapper ubicationRequestMapper;
    private final UbicationResponseMapper ubicationResponseMapper;

    @Override
    public SaveUbicationResponse save(SaveUbicationRequest request) {
        UbicationModel ubicationModel = ubicationRequestMapper.requestToModel(request);
        ubicationServicePort.save(ubicationModel, request.cityName());
        return new SaveUbicationResponse(ApplicationConstants.SAVE_UBICATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageInfo<UbicationResponse> getUbications(String searchText, Integer page, Integer size, String sortBy, boolean orderAsc) {
        PageInfo<UbicationModel> ubicationPageInfo = ubicationServicePort.getUbications(searchText, page, size, sortBy, orderAsc);
        List<UbicationResponse> ubicationResponses = ubicationPageInfo.getContent().stream()
                .map(ubicationResponseMapper::modelToResponse)
                .toList();

        return new PageInfo<>(
                ubicationResponses,
                ubicationPageInfo.getTotalElements(),
                ubicationPageInfo.getTotalPages(),
                ubicationPageInfo.getCurrentPage(),
                ubicationPageInfo.getPageSize(),
                ubicationPageInfo.isHasNext(),
                ubicationPageInfo.isHasPrevious()
        );
    }
}
