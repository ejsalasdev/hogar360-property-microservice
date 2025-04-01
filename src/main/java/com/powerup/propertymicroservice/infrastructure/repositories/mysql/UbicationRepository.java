package com.powerup.propertymicroservice.infrastructure.repositories.mysql;

import com.powerup.propertymicroservice.infrastructure.entities.UbicationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UbicationRepository extends JpaRepository<UbicationEntity, Long> {

    Optional<UbicationEntity> findBySectorAndCityId(String sector, Long cityId);

    @Query("SELECT u FROM UbicationEntity u " +
            "JOIN u.city c " +
            "JOIN c.department d " +
            "WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "OR LOWER(d.name) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    Page<UbicationEntity> searchUbications(@Param("searchText") String searchText, Pageable pageable);
}
