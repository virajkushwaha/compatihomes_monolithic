package com.housing.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String location;

    private double rent;

    private String features;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private User landlord;
}
