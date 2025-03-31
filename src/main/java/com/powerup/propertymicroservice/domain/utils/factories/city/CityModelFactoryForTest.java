package com.powerup.propertymicroservice.domain.utils.factories.city;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;

public class CityModelFactoryForTest {

    private CityModelFactoryForTest() {
    }

    public static CityModel createNewCityModel(String name, String description, DepartmentModel departmentModel) {
        return new CityModel(null, name, description, departmentModel);
    }

    public static CityModel createExistingCityModel(Long id, String name, String description, DepartmentModel departmentModel) {
        return new CityModel(id, name, description, departmentModel);
    }
}
