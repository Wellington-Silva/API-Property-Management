package com.wellsolutions.API_Property_Management.services;

import com.wellsolutions.API_Property_Management.domains.Property;
import com.wellsolutions.API_Property_Management.repositories.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class PropertyService {

    private PropertyRepository repository;

    public Property create(Property propertyData) {
        Property property = new Property();
        property.setName(propertyData.getName());
        property.setDescription(propertyData.getDescription());
        property.setValue(propertyData.getValue());
        return repository.save(propertyData);
    }

    public Property listProperties(UUID userId) {
        return repository.findByUserId()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No properties listed."));
    }

    public Property propertyDetails(@PathVariable UUID id) {
       return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found"));
    }

}
