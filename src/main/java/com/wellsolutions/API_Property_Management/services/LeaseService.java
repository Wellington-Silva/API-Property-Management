package com.wellsolutions.API_Property_Management.services;

import com.wellsolutions.API_Property_Management.domains.Lease;
import com.wellsolutions.API_Property_Management.domains.Property;
import com.wellsolutions.API_Property_Management.repositories.LeaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class LeaseService {

    private LeaseRepository repository;

    public List<Lease> listLeases(UUID tenantId) {
        List<Lease> leases = repository.findByPropertyd(tenantId);
        if (leases.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No leases listed");
        return leases;
    }

    public Lease createLease(Lease data) {
        Lease newLease = new Lease();
        newLease.setValue(data.getValue());
        newLease.setStartDate(data.getStartDate());
        newLease.setEndDate(data.getEndDate());
        newLease.setPropertyId(data.getPropertyId());
        newLease.setTenantId(data.getTenantId());
        return repository.save(newLease);
    }

    public Lease updateLease(UUID id, Lease data) {
        return repository.findById(id)
                .map(lease -> {
                    lease.setValue(data.getValue());
                    lease.setStartDate(data.getStartDate());
                    lease.setEndDate(data.getEndDate());
                    lease.setPropertyId(data.getPropertyId());
                    lease.setTenantId(data.getTenantId());
                    return repository.save(lease);
                })
                .orElseThrow(() -> new EntityNotFoundException("Lease not found"));
    }

    public void deleteLease(UUID id) {
        Lease lease = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        lease.setIsDisabled(true);
        repository.save(lease);
    }

}
