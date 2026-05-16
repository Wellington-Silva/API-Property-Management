package com.wellsolutions.API_Property_Management.services;

import com.wellsolutions.API_Property_Management.DTOs.CreateTenantDTO;
import com.wellsolutions.API_Property_Management.DTOs.UpdateTenantDTO;
import com.wellsolutions.API_Property_Management.domains.Tenant;
import com.wellsolutions.API_Property_Management.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TenantService {

    private TenantRepository repository;

    public Tenant tenantDetails(UUID id) {
        Tenant tenant = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tenant not found"));
        return tenant;
    }

    public Tenant createTenant(CreateTenantDTO data) {
        Tenant newTenant = new Tenant();
        newTenant.setName(data.name());
        newTenant.setPhone(data.phone());
        newTenant.setDocument(data.document());
        newTenant.setBirthDate(data.birthDate());
        return repository.save(newTenant);
    }

    public Tenant updateTenant(UUID id, UpdateTenantDTO data) {
        return repository.findById(id)
                .map(tenant -> {
                    tenant.setName(data.name());
                    tenant.setPhone(data.phone());
                    tenant.setDocument(data.document());
                    tenant.setBirthDate(data.birthDate());
                    return repository.save(tenant);
                })
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
    }

    public void deleteTenant(UUID id) {
        repository.deleteById(id);
    }

}
