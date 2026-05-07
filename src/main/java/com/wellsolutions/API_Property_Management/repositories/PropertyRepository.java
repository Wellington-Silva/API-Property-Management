package com.wellsolutions.API_Property_Management.repositories;

import com.wellsolutions.API_Property_Management.domains.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
    Optional<Property> findByUserId();
}
