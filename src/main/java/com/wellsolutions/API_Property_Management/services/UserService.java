package com.wellsolutions.API_Property_Management.services;

import com.wellsolutions.API_Property_Management.DTOs.UpdateProfileDTO;
import com.wellsolutions.API_Property_Management.domains.User;
import com.wellsolutions.API_Property_Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User userDetails(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User updateProfile(UUID id, UpdateProfileDTO data) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(data.name());
                    user.setPhone(data.phone());
                    user.setBirthDate(data.birthDate());
                    user.setEmail(data.email());
                    return repository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteAccount(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setDisabled(true);
        repository.save(user);
    }

}