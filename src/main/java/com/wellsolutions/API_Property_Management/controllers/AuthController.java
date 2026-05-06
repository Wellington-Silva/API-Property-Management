package com.wellsolutions.API_Property_Management.controllers;

import com.wellsolutions.API_Property_Management.DTOs.LoginDTO;
import com.wellsolutions.API_Property_Management.DTOs.RegisterUserDTO;
import com.wellsolutions.API_Property_Management.DTOs.ResponseDTO;
import com.wellsolutions.API_Property_Management.domains.User;
import com.wellsolutions.API_Property_Management.infra.security.TokenService;
import com.wellsolutions.API_Property_Management.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO body) {
        try {
            User user = repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
            if (user.isDisabled()) throw new RuntimeException("User is disabled");
            if (passwordEncoder.matches(body.password(), user.getPassword())) {
                String token = this.tokenService.generateToken(user);
                return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterUserDTO body) {
        Optional<User> user = repository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setName(body.name());
            newUser.setPhone(body.phone());
            newUser.setBirthDate(body.birthDate());
            newUser.setEmail(body.email());
            newUser.setPassword(body.password());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
