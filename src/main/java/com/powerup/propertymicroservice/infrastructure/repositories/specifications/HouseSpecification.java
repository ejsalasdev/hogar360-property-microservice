package com.powerup.propertymicroservice.infrastructure.repositories.specifications;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class HouseSpecification {

    private HouseSpecification() {
    }

    public static Specification<HouseEntity> withFilters(
            Long categoryId,
            Long ubicationId,
            Integer minRooms,
            Integer maxRooms,
            Integer minBathrooms,
            Integer maxBathrooms,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            PublicationStatus publicationStatus
    ) {
        return (Root<HouseEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            
            if (categoryId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.join("category").get("id"), categoryId));
            }
            if (ubicationId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.join("ubication").get("id"), ubicationId));
            }
            if (minRooms != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("numberOfRooms"), minRooms));
            }
            if (maxRooms != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("numberOfRooms"), maxRooms));
            }
            if (minBathrooms != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("numberOfBathrooms"), minBathrooms));
            }
            if (maxBathrooms != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("numberOfBathrooms"), maxBathrooms));
            }
            if (minPrice != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
            }
            if (maxPrice != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
            }
            if (publicationStatus != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("publicationStatus"), publicationStatus));
            }

            return predicate;
        };
    }
}
