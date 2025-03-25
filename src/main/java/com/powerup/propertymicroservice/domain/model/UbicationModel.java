package com.powerup.propertymicroservice.domain.model;

import java.util.Objects;

public class UbicationModel {

    private Long id;
    private DepartmentModel department;
    private CityModel city;

    public UbicationModel(Long id, DepartmentModel department, CityModel city) {
        this.id = id;
        this.department = department;
        this.city = city;
    }

    public Long getId() {
        return id;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UbicationModel that = (UbicationModel) o;
        return Objects.equals(department, that.department) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, city);
    }
}