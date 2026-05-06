package com.wellsolutions.API_Property_Management.DTOs;

import java.util.Date;

public record RegisterUserDTO(
        String name,
        String phone,
        String birthDate,
        String email,
        String password
) { }
