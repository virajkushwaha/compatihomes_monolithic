package com.housing.controller;

import com.housing.model.entity.Property;
import com.housing.repository.PropertyRepository;
import com.housing.repository.UserRepository;
import com.housing.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:4200/")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/landlord/{landlordId}")
    public Property addProperty(@PathVariable Long landlordId, @RequestBody Property property) {
        User landlord = userRepo.findById(landlordId)
                .orElseThrow(() -> new RuntimeException("Landlord not found"));
        property.setLandlord(landlord);
        return propertyRepo.save(property);
    }

    @GetMapping("/landlord/{landlordId}")
    public List<Property> getPropertiesByLandlord(@PathVariable Long landlordId) {
        return propertyRepo.findByLandlordId(landlordId);
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepo.findAll();
    }
}
