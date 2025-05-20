package com.powerup.propertymicroservice.application.handler;

import java.util.List;

import com.powerup.propertymicroservice.application.dto.response.DepartmentResponse;

public interface DepartmentHandler {

    List<DepartmentResponse> getAllDepartments(boolean orderAsc);
}
