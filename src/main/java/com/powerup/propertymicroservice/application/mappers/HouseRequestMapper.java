package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HouseRequestMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "ubicationId", target = "ubication.id")
    HouseModel requestToModel(SaveHouseRequest request);
}
