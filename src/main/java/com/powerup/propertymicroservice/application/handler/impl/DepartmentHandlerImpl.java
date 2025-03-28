package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveDepartmentRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveDepartmentResponse;
import com.powerup.propertymicroservice.application.handler.DepartmentHandler;
import com.powerup.propertymicroservice.application.mappers.DepartmentRequestMapper;
import com.powerup.propertymicroservice.application.utils.constants.ApplicationConstants;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.in.DepartmentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DepartmentHandlerImpl implements DepartmentHandler {

    private final DepartmentRequestMapper departmentRequestMapper;
    private final DepartmentServicePort departmentServicePort;

    @Override
    public SaveDepartmentResponse save(SaveDepartmentRequest saveDepartmentRequest) {
        DepartmentModel departmentModel = departmentRequestMapper.requestToModel(saveDepartmentRequest);
        departmentServicePort.save(departmentModel);
        return new SaveDepartmentResponse(ApplicationConstants.SAVE_DEPARTMENT_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
