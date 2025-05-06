package com.housing.controller;

import com.housing.model.entity.User;
import com.housing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

//    @GetMapping("/tenants")
//    public ResponseEntity<List<User>> getTenants() {
//        return ResponseEntity.ok(userRepository.findByRole(Role.TENANT));
//    }
//
//    @GetMapping("/landlords")
//    public ResponseEntity<List<User>> getLandlords() {
//        return ResponseEntity.ok(userRepository.findByRole(Role.LANDLORD));
//    }
}
