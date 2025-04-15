package com.powerup.propertymicroservice.infrastructure.utils.sort;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class HouseSortHelper {
    
    public Sort createSort(String sortBy, String sortDirection){
        Sort sort = Sort.by("id");
        if (sortBy.equalsIgnoreCase("ubication")){
            sort = Sort.by("ubication");
        } else if (sortBy.equalsIgnoreCase("category")) {
            sort = Sort.by("category");
        } else if (sortBy.equalsIgnoreCase("numberOfRooms")) {
            sort = Sort.by("numberofrooms");
        } else if (sortBy.equalsIgnoreCase("numberOfBathrooms")) {
            sort = Sort.by("numberofbathrooms");
        } else if (sortBy.equalsIgnoreCase("maxPrice")) {
            sort = Sort.by("maxprice");
        } else if (sortBy.equalsIgnoreCase("minPrice")) {
            sort = Sort.by("minprice");
        } else if (!sortBy.equalsIgnoreCase("id")) {
            sort = Sort.by(sortBy);
        }

        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        return sort;
    }
}
