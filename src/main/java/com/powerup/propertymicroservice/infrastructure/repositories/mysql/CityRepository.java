package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.powerup.propertymicroservice.infrastructure.entities.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    
    Optional<CityEntity> findByName(String name);
    List<CityEntity> findAllByName(String name);
    Optional<CityEntity> findByNameIgnoreCaseAndDepartment_NameIgnoreCase(String name, String departmentName);

    List<CityEntity> findAllByDepartment_Id(Long departmentId);
}
