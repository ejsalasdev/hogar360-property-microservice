package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;

public interface DepartmentServicePort {
    
    void save(DepartmentModel departmentModel);
}
