package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveUbicationResponse;
import com.powerup.propertymicroservice.application.dto.response.UbicationResponse;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

public interface UbicationHandler {
    
    SaveUbicationResponse save(SaveUbicationRequest saveUbicationRequest);
    PageInfo<UbicationResponse> getUbications(String searchText, Integer page, Integer size, String sortBy, boolean orderAsc);
}
