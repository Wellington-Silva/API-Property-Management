package com.wellsolutions.API_Property_Management.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="properties")
@Entity(name="properties")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private Integer value;

    private boolean isDisabled;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime UpdatedAt;
}