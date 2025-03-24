package com.powerup.propertymicroservice.domain.model;

import java.util.Objects;

public class UbicationModel {
    
    private Long id;
    private String name;
    private String description;
    private DepartmentModel department;
    private CityModel city;

    public UbicationModel(Long id, String name, String description, DepartmentModel department, CityModel city) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.department = department;
        this.city = city;
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

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UbicationModel that = (UbicationModel) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(department, that.department) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, department, city);
    }
}
