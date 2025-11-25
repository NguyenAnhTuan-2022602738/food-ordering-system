package com.foodordering.auth.infrastructure.config;

import com.foodordering.auth.domain.service.JwtService;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.util.Map;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Bean
    public SecretKey jwtSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    @Bean
    public JwtService jwtService(SecretKey secretKey) {
        return new JwtService() {
            @Override
            public String generateToken(com.foodordering.auth.domain.model.User user) {
                // Implementation will be added
                return "token";
            }

            @Override
            public boolean validateToken(String token) {
                // Implementation will be added
                return true;
            }

            @Override
            public String extractUsername(String token) {
                // Implementation will be added
                return "username";
            }

            @Override
            public Map<String, Object> extractClaims(String token) {
                // Implementation will be added
                return Map.of();
            }
        };
    }
}