package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;

import java.util.Optional;

public interface DepartmentPersistencePort {
    
    Optional<DepartmentModel> getDepartmentByName(String name);
}
