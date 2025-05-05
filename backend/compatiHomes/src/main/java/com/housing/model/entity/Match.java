package com.housing.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "matches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tenantId;

    private Long landlordId;

    private boolean accepted;
}
