package com.powerup.propertymicroservice.infrastructure.utils.sort;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class HouseSortHelper {
    
    public Sort createSort(String sortBy, String sortDirection) {
        String sortFieldToUse;

        if (sortBy == null || sortBy.trim().isEmpty()) {
            sortFieldToUse = "id";
        } else {
            String normalizedSortBy = sortBy.toLowerCase();
            sortFieldToUse = switch (normalizedSortBy) {
                case "ubication" -> "ubication";
                case "category" -> "category";
                case "numberofrooms" -> "numberOfRooms";
                case "numberofbathrooms" -> "numberOfBathrooms";
                case "price" -> "price";
                case "id" -> "id";
                default -> sortBy;
            };
        }

        Sort sort = Sort.by(sortFieldToUse);

        if (sortDirection != null && sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        
        return sort;
    }
}
