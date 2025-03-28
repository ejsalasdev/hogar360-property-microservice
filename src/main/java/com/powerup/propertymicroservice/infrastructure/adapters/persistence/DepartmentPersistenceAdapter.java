package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.infrastructure.entities.DepartmentEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.DepartmentEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {
    
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public void save(DepartmentModel departmentModel) {
        DepartmentEntity departmentEntity = departmentEntityMapper.modelToEntity(departmentModel);
        departmentRepository.save(departmentEntity);
    }

    @Override
    public Optional<DepartmentModel> getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(departmentEntityMapper::entityToModel);
    }

    @Override
    public Optional<DepartmentModel> getDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName).map(departmentEntityMapper::entityToModel);
    }
}
