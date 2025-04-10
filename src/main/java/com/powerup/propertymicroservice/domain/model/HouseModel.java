package com.powerup.propertymicroservice.domain.model;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HouseModel {

    private Long id;
    private String name;
    private String description;
    private CategoryModel category;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private BigDecimal price;
    private UbicationModel ubication;
    private String address;
    private LocalDate activePublicationDate;
    private PublicationStatus publicationStatus;
    private LocalDate publicationDate;

    public HouseModel(Long id, String name, String description, CategoryModel category,
                      Integer numberOfRooms, Integer numberOfBathrooms, BigDecimal price,
                      UbicationModel ubication, String address, LocalDate activePublicationDate,
                      PublicationStatus publicationStatus, LocalDate publicationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.price = price;
        this.ubication = ubication;
        this.address = address;
        this.activePublicationDate = activePublicationDate;
        this.publicationStatus = publicationStatus;
        this.publicationDate = publicationDate;
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

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UbicationModel getUbication() {
        return ubication;
    }

    public void setUbication(UbicationModel ubication) {
        this.ubication = ubication;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getActivePublicationDate() {
        return activePublicationDate;
    }

    public void setActivePublicationDate(LocalDate activePublicationDate) {
        this.activePublicationDate = activePublicationDate;
    }

    public PublicationStatus getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(PublicationStatus publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}