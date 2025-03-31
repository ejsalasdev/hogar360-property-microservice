package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.response.UbicationResponse;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UbicationResponseMapper {

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.department.name", target = "departmentName")
    UbicationResponse modelToResponse(UbicationModel ubicationModel);

    List<UbicationResponse> modelListToResponseList(List<UbicationModel> ubications);
}
