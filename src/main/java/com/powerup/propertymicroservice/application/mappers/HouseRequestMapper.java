package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HouseRequestMapper {
    
    HouseModel requestToModel(SaveHouseRequest request);
}
