package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    Optional<DepartmentEntity> findByName(String name);
}
