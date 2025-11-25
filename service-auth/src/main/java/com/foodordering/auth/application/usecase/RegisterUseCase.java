package com.foodordering.auth.application.usecase;

import com.foodordering.auth.domain.event.UserRegisteredEvent;
import com.foodordering.auth.domain.model.User;
import com.foodordering.auth.domain.model.UserRole;
import com.foodordering.auth.domain.repository.UserRepository;
import com.foodordering.auth.domain.service.PasswordEncoderService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoderService passwordEncoderService;
    private final ApplicationEventPublisher eventPublisher;

    public RegisterUseCase(UserRepository userRepository,
                          PasswordEncoderService passwordEncoderService,
                          ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoderService = passwordEncoderService;
        this.eventPublisher = eventPublisher;
    }

    public User execute(String email, String password, String fullName, UserRole role) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        String encodedPassword = passwordEncoderService.encode(password);
        User user = new User(email, encodedPassword, fullName, role);
        User savedUser = userRepository.save(user);

        // Publish event
        eventPublisher.publishEvent(new UserRegisteredEvent(savedUser));

        return savedUser;
    }
}