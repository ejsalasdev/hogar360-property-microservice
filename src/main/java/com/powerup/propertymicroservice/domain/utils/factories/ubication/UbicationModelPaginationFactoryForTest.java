package com.powerup.propertymicroservice.domain.utils.factories.ubication;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class UbicationModelPaginationFactoryForTest {

    private UbicationModelPaginationFactoryForTest() {
    }

    public static PageInfo<UbicationModel> createPageInfo(List<UbicationModel> content, long totalElements, int totalPages, int currentPage, int pageSize, boolean hasNext, boolean hasPrevious) {
        return new PageInfo<>(
                content,
                totalElements,
                totalPages,
                currentPage,
                pageSize,
                hasNext,
                hasPrevious
        );
    }

    public static List<UbicationModel> createUbicationModelList(int size) {
        List<UbicationModel> ubications = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            // Crear una CityModel para cada UbicationModel
            CityModel city = new CityModel((long) i, "Ciudad " + i, "Descripcion " + i,
                    new DepartmentModel((long) i, "Departamento " + i, "Descripcion " + i));
            UbicationModel ubication = UbicationModelFactoryForTest.createUbicationModel((long) i, "Sector " + i, city);
            ubications.add(ubication);
        }
        return ubications;
    }

    public static PageInfo<UbicationModel> createEmptyPageInfo(int currentPage, int pageSize) {
        return createPageInfo(new ArrayList<>(), 0, 0, currentPage, pageSize, false, false);
    }

}
