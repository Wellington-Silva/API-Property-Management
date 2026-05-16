package com.wellsolutions.API_Property_Management.controllers;

import com.wellsolutions.API_Property_Management.domains.Lease;
import com.wellsolutions.API_Property_Management.services.LeaseService;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lease")
@NoArgsConstructor
public class LeaseController {

    private LeaseService service;

    @GetMapping("/{propertyId}")
    public ResponseEntity<List<Lease>> listLeases(@PathVariable UUID propertyId) {
        return ResponseEntity.ok(service.listLeases(propertyId));
    }

    @PostMapping("/")
    public ResponseEntity<Lease> createLease(@RequestBody Lease data) {
        return ResponseEntity.ok(service.createLease(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lease> updateLease(@PathVariable UUID id, @RequestBody Lease data) {
        return ResponseEntity.ok(service.updateLease(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLease(@PathVariable UUID id) {
        service.deleteLease(id);
        return ResponseEntity.ok("Aluguel deletado");
    }

}
