package com.wellsolutions.API_Property_Management.controllers;

import com.wellsolutions.API_Property_Management.DTOs.UpdatePropertyDTO;
import com.wellsolutions.API_Property_Management.domains.Property;
import com.wellsolutions.API_Property_Management.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private PropertyService service;

    @GetMapping("/{userId}/properties")
    public ResponseEntity<List<Property>> listProperties(@PathVariable UUID userId) {
        try {
            return ResponseEntity.ok(service.listProperties(userId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> propertyDetails(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(service.propertyDetails(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Property> create(@RequestBody Property data) {
        try {
            return ResponseEntity.ok(service.create(data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable UUID id, @RequestBody UpdatePropertyDTO data) {
        try {
            return ResponseEntity.ok(service.updateProperty(id, data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable UUID id) {
        try {
            service.deleteProperty(id);
            return ResponseEntity.ok("Imóvel deletado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}