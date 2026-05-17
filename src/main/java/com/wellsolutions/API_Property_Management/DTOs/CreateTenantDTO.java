package com.wellsolutions.API_Property_Management.DTOs;

import java.time.LocalDateTime;

public record CreateTenantDTO(
        String name,
        String document,
        LocalDateTime birthDate,
        String phone
) {
}
