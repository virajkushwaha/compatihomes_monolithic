package com.housing.controller;

import com.housing.model.entity.User;
import com.housing.repository.UserRepository;
import com.housing.services.MatchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/") // allow frontend access
public class MatchController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MatchServices matchService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/matches/{tenantId}")
    public List<User> getMatches(@PathVariable Long tenantId) {
        return matchService.findMatchesForTenant(tenantId);
    }

    @PostMapping("/matches/accept/{matchId}")
    public void acceptMatch(@PathVariable Long matchId) {
        matchService.acceptMatch(matchId);
    }
}
