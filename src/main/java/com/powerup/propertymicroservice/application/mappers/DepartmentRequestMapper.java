package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.request.SaveDepartmentRequest;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentRequestMapper {
    
    DepartmentModel requestToModel(SaveDepartmentRequest saveDepartmentRequest);
}
