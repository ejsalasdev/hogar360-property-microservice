package com.powerup.propertymicroservice.domain.model;

import java.util.Objects;

public class CityModel {
    
    private Long id;
    private String name;
    private String description;

    public CityModel(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CityModel cityModel = (CityModel) o;
        return Objects.equals(name, cityModel.name) && Objects.equals(description, cityModel.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
