package com.powerup.propertymicroservice.infrastructure.repositories.specifications;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class HouseSpecification {

    private HouseSpecification() {
    }

    public static Specification<HouseEntity> withFilters(
            Long categoryId,
            String ubicationSearchText,
            PublicationStatus publicationStatus,
            Long sellerId
    ) {
        return (Root<HouseEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (categoryId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.join("category").get("id"), categoryId));
            }
            if (ubicationSearchText != null && !ubicationSearchText.trim().isEmpty()) {
                Predicate sectorPredicate = criteriaBuilder.like(
                        criteriaBuilder.lower(root.join("ubication").get("sector")),
                        "%" + ubicationSearchText.trim().toLowerCase() + "%"
                );

                Predicate cityPredicate = criteriaBuilder.like(
                        criteriaBuilder.lower(root.join("ubication").join("city").get("name")),
                        "%" + ubicationSearchText.trim().toLowerCase() + "%"
                );
                Predicate departmentPredicate = criteriaBuilder.like(
                        criteriaBuilder.lower(root.join("ubication").join("city").join("department").get("name")),
                        "%" + ubicationSearchText.trim().toLowerCase() + "%"
                );

                predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(sectorPredicate, cityPredicate, departmentPredicate));
            }
            if (publicationStatus != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("publicationStatus"), publicationStatus));
            }
            if (sellerId != null){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("sellerId"), sellerId));
            }
            return predicate;
        };
    }
}
