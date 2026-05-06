package com.wellsolutions.API_Property_Management.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Table(name="users")
@Entity(name="users")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String phone;

    @Column(name = "birthdate")
    private String birthDate;

    private String email;

    private String password;

    private boolean isDisabled;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime UpdatedAt;
}