package com.powerup.propertymicroservice.infrastructure.mappers;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.infrastructure.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {DepartmentEntityMapper.class})
public interface CityEntityMapper {

    @Mapping(source = "departmentModel", target = "department")
    CityEntity modelToEntity(CityModel cityModel);

    @Mapping(source = "department", target = "departmentModel")
    CityModel entityToModel(CityEntity cityEntity);
}
