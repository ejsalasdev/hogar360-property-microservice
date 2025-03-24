package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.in.DepartmentServicePort;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationsExceptionsMessagesConstants;

import java.util.Optional;

public class DepartmentUseCase implements DepartmentServicePort {

    public final DepartmentPersistencePort departmentPersistencePort;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
    }
    
    @Override
    public void save(DepartmentModel departmentModel) {
        Optional<DepartmentModel> department = departmentPersistencePort.getDepartmentByName(departmentModel.getName());
        if (department.isPresent()) {
            throw new ElementAlreadyExistsException(UbicationsExceptionsMessagesConstants.DEPARTMENT_EXISTS_EXCEPTION + departmentModel.getName());
        }
        departmentPersistencePort.save(departmentModel);

    }
}
