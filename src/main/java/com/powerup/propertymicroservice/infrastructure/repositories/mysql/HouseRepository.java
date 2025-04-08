package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {
}
