package com.wellsolutions.API_Property_Management.repositories;

import com.wellsolutions.API_Property_Management.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
