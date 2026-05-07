package com.wellsolutions.API_Property_Management.services;

import com.wellsolutions.API_Property_Management.DTOs.UpdatePropertyDTO;
import com.wellsolutions.API_Property_Management.domains.Property;
import com.wellsolutions.API_Property_Management.repositories.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    public List<Property> listProperties(UUID userId) {
        List<Property> properties = repository.findByUserId(userId);
        if (properties.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No properties listed");
        return properties;
    }

    public Property propertyDetails(UUID id) {
       return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found"));
    }

    public Property updateProperty(UUID id, UpdatePropertyDTO data) {
        return repository.findById(id)
                .map(property -> {
                      property.setName(data.name());
                      property.setDescription(data.description());
                      property.setValue(data.value());
                      return repository.save(property);
                })
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public void deleteProperty(UUID id) {
        Property property = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        property.setDisabled(true);
        repository.save(property);
    }

}