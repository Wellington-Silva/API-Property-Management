package com.wellsolutions.API_Property_Management.repositories;

import com.wellsolutions.API_Property_Management.domains.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {
}
