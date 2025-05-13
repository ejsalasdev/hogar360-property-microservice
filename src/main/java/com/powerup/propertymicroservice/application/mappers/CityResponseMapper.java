package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.response.CityResponse;
import com.powerup.propertymicroservice.domain.model.CityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityResponseMapper {
    
    CityResponse modelToResponse(CityModel cityModel);
}
