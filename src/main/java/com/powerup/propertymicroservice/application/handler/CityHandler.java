package com.powerup.propertymicroservice.application.handler;

import java.util.List;

import com.powerup.propertymicroservice.application.dto.response.CityResponse;

public interface CityHandler {
    
    List<CityResponse> getAllCitiesByDepartmentId(Long departmentId, boolean orderAsc);
}
