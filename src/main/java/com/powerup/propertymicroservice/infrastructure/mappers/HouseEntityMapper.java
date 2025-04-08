package com.powerup.propertymicroservice.infrastructure.mappers;

import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CategoryEntityMapper.class, UbicationEntityMapper.class})
public interface HouseEntityMapper {

    @Mapping(source = "category", target = "category")
    @Mapping(source = "ubication", target = "ubication")
    HouseEntity modelToEntity(HouseModel houseModel);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "ubication", target = "ubication")
    HouseModel entityToModel(HouseEntity houseEntity);
}
