package com.powerup.propertymicroservice.infrastructure.mappers;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentEntityMapper {
    
    DepartmentEntity modelToEntity(DepartmentModel departmentModel);
    DepartmentModel entityToModel(DepartmentEntity departmentEntity);    
    List<DepartmentModel> entityListToModel(List<DepartmentEntity> departments);
}
