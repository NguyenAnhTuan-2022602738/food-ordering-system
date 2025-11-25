package com.foodordering.auth.application.mapper;

import com.foodordering.auth.application.dto.UserResponseDto;
import com.foodordering.auth.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
            user.getId(),
            user.getEmail(),
            user.getFullName(),
            user.getRole(),
            user.getCreatedAt(),
            user.getLastLoginAt()
        );
    }
}