package com.wellsolutions.API_Property_Management.controllers;

import com.wellsolutions.API_Property_Management.DTOs.UpdateProfileDTO;
import com.wellsolutions.API_Property_Management.domains.User;
import com.wellsolutions.API_Property_Management.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> userDetails(@PathVariable UUID id) {
        User user = service.userDetails(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable UUID id, @RequestBody UpdateProfileDTO data) {
        User user = service.updateProfile(id, data);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable UUID id) {
        service.deleteAccount(id);
        return ResponseEntity.ok("Sua conta foi deletada com sucesso");
    }

}