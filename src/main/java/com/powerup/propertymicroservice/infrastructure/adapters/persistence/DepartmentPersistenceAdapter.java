package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.infrastructure.mappers.DepartmentEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {
    
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public Optional<DepartmentModel> getDepartmentByName(String name) {
        return departmentRepository.findByName(name).map(departmentEntityMapper::entityToModel);
    }

    @Override
    public List<DepartmentModel> findAll() {
        return departmentRepository.findAll().stream()
                .map(departmentEntityMapper::entityToModel)
                .toList();
    }
}
