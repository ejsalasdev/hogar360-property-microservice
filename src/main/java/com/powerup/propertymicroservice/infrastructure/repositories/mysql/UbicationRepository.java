package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.UbicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UbicationRepository extends JpaRepository<UbicationEntity, Long> {

    Optional<UbicationEntity> findBySectorAndCityId(String sector, Long cityId);
}
