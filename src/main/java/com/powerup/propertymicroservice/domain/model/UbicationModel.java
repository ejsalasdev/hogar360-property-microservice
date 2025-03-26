package com.powerup.propertymicroservice.domain.model;

import java.util.Objects;

public class UbicationModel {

    private Long id;
    private String sector;
    private CityModel city;

    public UbicationModel(Long id, String sector, CityModel city) {
        this.id = id;
        this.sector = sector;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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
        return Objects.equals(sector, that.sector) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sector, city);
    }
}