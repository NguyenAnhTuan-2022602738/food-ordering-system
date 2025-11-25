package com.foodordering.auth.infrastructure.config;

import com.foodordering.auth.domain.service.PasswordEncoderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoderService passwordEncoderService() {
        return new PasswordEncoderService() {
            private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            @Override
            public String encode(String rawPassword) {
                return encoder.encode(rawPassword);
            }

            @Override
            public boolean matches(String rawPassword, String encodedPassword) {
                return encoder.matches(rawPassword, encodedPassword);
            }
        };
    }
}