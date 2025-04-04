package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.response.UbicationResponse;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UbicationResponseMapper {
    
    default UbicationResponse modelToResponse(UbicationModel ubicationModel) {
        return new UbicationResponse(
                ubicationModel.getId(),
                ubicationModel.getSector(),
                ubicationModel.getCity().getName(),
                ubicationModel.getCity().getDepartmentModel().getName()
                );
    }
}
