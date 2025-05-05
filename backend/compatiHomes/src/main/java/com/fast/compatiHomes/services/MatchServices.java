package com.fast.compatiHomes.services;


import com.fast.compatiHomes.model.Match;
import com.fast.compatiHomes.model.User;
import com.fast.compatiHomes.repo.MatchRepository;
import com.fast.compatiHomes.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchServices {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MatchRepository matchRepo;

    public List<User> findMatchesForTenant(Long tenantId) {
        User tenant = userRepo.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));

        String[] prefs = tenant.getPreferences().split(",");

        List<User> landlords = userRepo.findAll().stream()
                .filter(user -> "LANDLORD".equalsIgnoreCase(user.getRole()))
                .filter(landlord -> calculateMatchPercentage(prefs, landlord.getOfferings()) >= 60)
                .collect(Collectors.toList());

        // Save match records
        landlords.forEach(landlord -> {
            Match match = Match.builder()
                    .tenantId(tenantId)
                    .landlordId(landlord.getId())
                    .accepted(false)
                    .build();
            matchRepo.save(match);
        });

        return landlords;
    }

    private int calculateMatchPercentage(String[] prefs, String offerings) {
        String[] offers = offerings.split(",");
        int matchCount = 0;
        for (String pref : prefs) {
            for (String offer : offers) {
                if (pref.trim().equalsIgnoreCase(offer.trim())) {
                    matchCount++;
                }
            }
        }
        return (int) ((matchCount / (double) prefs.length) * 100);
    }

    public void acceptMatch(Long matchId) {
        Match match = matchRepo.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));
        match.setAccepted(true);
        matchRepo.save(match);
    }
}

