package com.wellsolutions.API_Property_Management.repositories;

import com.wellsolutions.API_Property_Management.domains.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LeaseRepository extends JpaRepository<Lease, UUID> {
    public List<Lease> findByPropertyd(UUID id);
}
