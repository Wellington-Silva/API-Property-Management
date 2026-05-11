package com.wellsolutions.API_Property_Management.controllers;

import com.wellsolutions.API_Property_Management.DTOs.CreateTenantDTO;
import com.wellsolutions.API_Property_Management.DTOs.UpdateTenantDTO;
import com.wellsolutions.API_Property_Management.domains.Tenant;
import com.wellsolutions.API_Property_Management.services.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController()
@RequestMapping("tenant")
@AllArgsConstructor
public class TenantController {

    private TenantService service;

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> tenantDetails(@PathVariable UUID id) {
        return ResponseEntity.ok(service.tenantDetails(id));
    }

    @PostMapping("/")
    public ResponseEntity<Tenant> createTenant(@RequestBody CreateTenantDTO data) {
        Tenant tenant = service.createTenant(data);
        return new ResponseEntity<>(tenant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable UUID id, @RequestBody UpdateTenantDTO data) {
        Tenant newTenant = service.updateTenant(id, data);
        return ResponseEntity.ok(newTenant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTenant(@PathVariable UUID id) {
        service.deleteTenant(id);
        return ResponseEntity.ok("Usuário deletado");
    }
}