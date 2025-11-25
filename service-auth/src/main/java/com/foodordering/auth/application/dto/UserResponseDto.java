package com.foodordering.auth.application.dto;

import com.foodordering.auth.domain.model.UserRole;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserResponseDto {
    private UUID id;
    private String email;
    private String fullName;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    public UserResponseDto() {}

    public UserResponseDto(UUID id, String email, String fullName, UserRole role,
                          LocalDateTime createdAt, LocalDateTime lastLoginAt) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.createdAt = createdAt;
        this.lastLoginAt = lastLoginAt;
    }

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getLastLoginAt() { return lastLoginAt; }
    public void setLastLoginAt(LocalDateTime lastLoginAt) { this.lastLoginAt = lastLoginAt; }
}