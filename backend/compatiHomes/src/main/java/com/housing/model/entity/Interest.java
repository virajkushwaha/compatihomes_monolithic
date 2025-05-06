package com.housing.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "interests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    private Long propertyId;

    private boolean shortlisted; // optional: can be used for future steps
}
