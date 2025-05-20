package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.in.DepartmentServicePort;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentsExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.departments.DepartmentValidator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DepartmentUseCase implements DepartmentServicePort {

    private final DepartmentPersistencePort departmentPersistencePort;
    private final DepartmentValidator departmentValidator;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort, DepartmentValidator departmentValidator) {
        this.departmentPersistencePort = departmentPersistencePort;
        this.departmentValidator = departmentValidator;
    }

    @Override
    public DepartmentModel getDepartmentByName(String name) {
        departmentValidator.validateDepartmentName(name);
        Optional<DepartmentModel> department = departmentPersistencePort.getDepartmentByName(name);
        if (department.isEmpty()) {
            throw new ElementNotFoundException(String.format(DepartmentsExceptionsMessagesConstants.DEPARTMENT_NOT_FOUND_EXCEPTION, name));
        }
        return department.get();
    }

    @Override
    public List<DepartmentModel> getAllDepartments(boolean orderAsc) {
        List<DepartmentModel> departments = departmentPersistencePort.findAll();
        
        Comparator<DepartmentModel> comparator = Comparator.comparing(DepartmentModel::getName);

        if (!orderAsc) {
            comparator = comparator.reversed();
        }

        return departments.stream()
                .sorted(comparator)
                .toList();
    }
}