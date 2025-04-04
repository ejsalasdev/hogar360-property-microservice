package com.powerup.propertymicroservice.domain.utils.factories.department;

import com.powerup.propertymicroservice.domain.model.DepartmentModel;

public class DepartmentModelFactoryForTest {

    private DepartmentModelFactoryForTest() {
    }

    public static DepartmentModel createExistingDepartmentModel(Long id, String name, String description) {
        return new DepartmentModel(id, name, description);
    }
}
