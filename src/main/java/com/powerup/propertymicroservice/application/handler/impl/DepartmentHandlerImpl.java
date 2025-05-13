package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.response.DepartmentResponse;
import com.powerup.propertymicroservice.application.handler.DepartmentHandler;
import com.powerup.propertymicroservice.application.mappers.DepartmentResponseMapper;
import com.powerup.propertymicroservice.domain.ports.in.DepartmentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentHandlerImpl implements DepartmentHandler {

    private final DepartmentServicePort departmentServicePort;
    private final DepartmentResponseMapper departmentResponseMapper;

    @Override
    public List<DepartmentResponse> getAllDepartments(boolean orderAsc) {
        return departmentServicePort.getAllDepartments(orderAsc).stream()
                .map(departmentResponseMapper::modelToResponse)
                .toList();
    }
} 