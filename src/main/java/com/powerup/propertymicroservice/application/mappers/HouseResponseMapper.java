package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.response.HouseResponse;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HouseResponseMapper {
    
    default HouseResponse modelToResponse(HouseModel houseModel) {
        return new HouseResponse(
                houseModel.getId(),
                houseModel.getName(),
                houseModel.getDescription(),
                houseModel.getCategory().getName(),
                houseModel.getNumberOfRooms(),
                houseModel.getNumberOfBathrooms(),
                houseModel.getPrice(),
                houseModel.getAddress(),
                houseModel.getUbication().getSector(),
                houseModel.getUbication().getCity().getName(),
                houseModel.getUbication().getCity().getDepartmentModel().getName(),
                houseModel.getActivePublicationDate(),
                houseModel.getPublicationStatus(),
                houseModel.getPublicationDate(),
                houseModel.getSellerId()                
        );
    }
}
