package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.response.DepartmentResponse;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;

import java.util.List;

public interface DepartmentHandler {
    
    List<DepartmentResponse> getAllDepartments(boolean orderAsc);
}
