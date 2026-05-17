package com.wellsolutions.API_Property_Management.DTOs;

import java.time.LocalDateTime;

public record UpdateTenantDTO(String name, String document, LocalDateTime birthDate, String phone) {
}
