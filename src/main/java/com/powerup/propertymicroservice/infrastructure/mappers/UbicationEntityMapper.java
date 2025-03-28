package com.powerup.propertymicroservice.infrastructure.mappers;

import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.infrastructure.entities.UbicationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CityEntityMapper.class})
public interface UbicationEntityMapper {

    @Mapping(source = "city", target = "city")
    UbicationEntity modelToEntity(UbicationModel ubicationModel);

    @Mapping(source = "city", target = "city")
    UbicationModel entityToModel(UbicationEntity ubicationEntity);
}
