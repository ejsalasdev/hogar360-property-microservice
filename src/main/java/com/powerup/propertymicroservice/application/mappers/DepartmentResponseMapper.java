package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.response.DepartmentResponse;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentResponseMapper {
    
    DepartmentResponse modelToResponse(DepartmentModel departmentModel);
}
