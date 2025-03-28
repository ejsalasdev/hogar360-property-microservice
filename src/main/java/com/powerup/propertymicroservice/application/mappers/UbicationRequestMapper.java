package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UbicationRequestMapper {
    
    UbicationModel requestToModel(SaveUbicationRequest saveUbicationRequest);
}
