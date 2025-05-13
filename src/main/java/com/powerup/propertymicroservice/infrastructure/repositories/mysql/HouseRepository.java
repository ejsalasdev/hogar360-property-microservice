package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface HouseRepository extends JpaRepository<HouseEntity, Long>, JpaSpecificationExecutor<HouseEntity> {
    
    List<HouseEntity> findByActivePublicationDate(LocalDate activePublicationDate);
    
    Page<HouseEntity> findAll(Specification<HouseEntity> spec, Pageable pageable);

    boolean existsByCategory_Id(Long categoryId);
}
