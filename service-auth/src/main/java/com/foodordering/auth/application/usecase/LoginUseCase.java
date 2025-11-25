package com.foodordering.auth.application.usecase;

import com.foodordering.auth.domain.model.User;
import com.foodordering.auth.domain.repository.UserRepository;
import com.foodordering.auth.domain.service.JwtService;
import com.foodordering.auth.domain.service.PasswordEncoderService;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoderService passwordEncoderService;
    private final JwtService jwtService;

    public LoginUseCase(UserRepository userRepository,
                       PasswordEncoderService passwordEncoderService,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoderService = passwordEncoderService;
        this.jwtService = jwtService;
    }

    public String execute(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoderService.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        user.recordLogin();
        userRepository.save(user);

        return jwtService.generateToken(user);
    }
}