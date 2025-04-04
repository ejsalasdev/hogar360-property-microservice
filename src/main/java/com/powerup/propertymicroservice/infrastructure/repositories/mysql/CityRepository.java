package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    
    Optional<CityEntity> findByName(String name);
    List<CityEntity> findAllByName(String name);
    Optional<CityEntity> findByNameIgnoreCaseAndDepartment_NameIgnoreCase(String name, String departmentName);
}
