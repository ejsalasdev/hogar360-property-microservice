package com.powerup.propertymicroservice.infrastructure.adapters.persistence.department;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.infrastructure.entities.DepartmentEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.DepartmentEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.DepartmentRepository;

import java.util.Optional;

public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {
    
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;


    public DepartmentPersistenceAdapter(DepartmentRepository departmentRepository, DepartmentEntityMapper departmentEntityMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentEntityMapper = departmentEntityMapper;
    }

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
