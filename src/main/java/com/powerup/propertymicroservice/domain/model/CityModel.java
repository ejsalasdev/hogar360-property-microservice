package com.powerup.propertymicroservice.domain.model;

import java.util.Objects;

public class CityModel {
    
    private Long id;
    private String name;
    private String description;
    private DepartmentModel departmentModel;

    public CityModel(Long id, String name, String description, DepartmentModel departmentModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.departmentModel = departmentModel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentModel getDepartmentModel() {
        return departmentModel;
    }

    public void setDepartmentModel(DepartmentModel departmentModel) {
        this.departmentModel = departmentModel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CityModel cityModel = (CityModel) o;
        return Objects.equals(name, cityModel.name) && Objects.equals(description, cityModel.description) && Objects.equals(departmentModel, cityModel.departmentModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, departmentModel);
    }
}
