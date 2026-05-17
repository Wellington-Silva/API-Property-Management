package com.wellsolutions.API_Property_Management.DTOs;

import java.time.LocalDateTime;

public record UpdateProfileDTO(
        String name,
        String phone,
        LocalDateTime birthDate,
        String email
) {}