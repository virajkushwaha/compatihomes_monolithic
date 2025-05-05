package com.housing.controller;

import com.housing.model.entity.Interest;
import com.housing.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interests")
@CrossOrigin(origins = "http://localhost:4200/")
public class InterestController {

    @Autowired
    private InterestRepository interestRepo;

    @PostMapping("/tenant/{tenantId}/property/{propertyId}")
    public Interest expressInterest(@PathVariable Long tenantId, @PathVariable Long propertyId) {
        if (interestRepo.existsByTenantIdAndPropertyId(tenantId, propertyId)) {
            throw new RuntimeException("Interest already exists");
        }

        Interest interest = Interest.builder()
                .tenantId(tenantId)
                .propertyId(propertyId)
                .shortlisted(false)
                .build();

        return interestRepo.save(interest);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<Interest> getInterests(@PathVariable Long tenantId) {
        return interestRepo.findByTenantId(tenantId);
    }
}
