package com.wellsolutions.API_Property_Management.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateLeaseDTO(Integer value, LocalDateTime startDate, LocalDateTime endDate, UUID propertyId, UUID tenantId) {
}
