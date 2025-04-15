package com.powerup.propertymicroservice.infrastructure.utils.sort;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UbicationSortHelper {

    public Sort createSort(String sortBy, String sortDirection) {
        Sort sort = Sort.by("id");
        if (sortBy.equalsIgnoreCase("departmentName")) {
            sort = Sort.by("city.department.name");
        } else if (sortBy.equalsIgnoreCase("cityName")) {
            sort = Sort.by("city.name");
        } else if (!sortBy.equalsIgnoreCase("id")) {
            sort = Sort.by(sortBy);
        }

        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        return sort;
    }
}
