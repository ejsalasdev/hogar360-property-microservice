package com.powerup.propertymicroservice.infrastructure.entities;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "houses")
public class HouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(nullable = false)
    private Integer numberOfRooms;

    @Column(nullable = false)
    private Integer numberOfBathrooms;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "ubication_id", nullable = false)
    private UbicationEntity ubication;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDate activePublicationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PublicationStatus publicationStatus;

    @Column(nullable = false)
    private LocalDate publicationDate;
}
