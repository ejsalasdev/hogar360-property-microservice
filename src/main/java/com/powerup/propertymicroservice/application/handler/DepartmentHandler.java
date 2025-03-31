package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveDepartmentRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveDepartmentResponse;

public interface DepartmentHandler {
    
    SaveDepartmentResponse save(SaveDepartmentRequest saveDepartmentRequest);
}
