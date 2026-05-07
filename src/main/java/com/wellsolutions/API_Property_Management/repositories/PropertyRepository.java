package com.wellsolutions.API_Property_Management.repositories;

import com.wellsolutions.API_Property_Management.domains.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
    List<Property> findByUserId(UUID userId);
}