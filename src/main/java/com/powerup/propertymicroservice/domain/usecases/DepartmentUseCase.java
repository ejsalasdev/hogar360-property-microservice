package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.in.DepartmentServicePort;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentsExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.departments.DepartmentValidator;

import java.util.Optional;

public class DepartmentUseCase implements DepartmentServicePort {

    private final DepartmentPersistencePort departmentPersistencePort;
    private final DepartmentValidator departmentValidator;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort, DepartmentValidator departmentValidator) {
        this.departmentPersistencePort = departmentPersistencePort;
        this.departmentValidator = departmentValidator;
    }

    @Override
    public void save(DepartmentModel departmentModel) {
        departmentValidator.validateDepartment(departmentModel);
        Optional<DepartmentModel> department = departmentPersistencePort.getDepartmentByName(departmentModel.getName());
        if (department.isPresent()) {
            throw new ElementAlreadyExistsException(String.format(DepartmentsExceptionsMessagesConstants.DEPARTMENT_EXISTS_EXCEPTION, departmentModel.getName()));
        }
        departmentPersistencePort.save(departmentModel);
    }
    
    
}