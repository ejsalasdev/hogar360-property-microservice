package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {
    
    List<HouseEntity> findByActivePublicationDate(LocalDate activePublicationDate);
}
