package com.fast.compatiHomes.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Either "TENANT" or "LANDLORD"
    private String role;

    // Comma-separated preferences (for tenants) or offerings (for landlords)
    private String preferences; // only used if role = TENANT
    private String offerings;
    // only used if role = LANDLORD

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getOfferings() {
        return offerings;
    }

    public void setOfferings(String offerings) {
        this.offerings = offerings;
    }
}
