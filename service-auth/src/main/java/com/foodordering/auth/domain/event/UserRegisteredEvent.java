package com.foodordering.auth.domain.event;

import com.foodordering.auth.domain.model.User;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserRegisteredEvent {
    private final UUID userId;
    private final String email;
    private final String fullName;
    private final LocalDateTime registeredAt;

    public UserRegisteredEvent(User user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.fullName = user.getFullName();
        this.registeredAt = user.getCreatedAt();
    }

    // Getters
    public UUID getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public LocalDateTime getRegisteredAt() { return registeredAt; }
}