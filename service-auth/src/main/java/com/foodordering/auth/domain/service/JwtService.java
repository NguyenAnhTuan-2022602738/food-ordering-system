package com.foodordering.auth.domain.service;

import com.foodordering.auth.domain.model.User;
import java.util.Map;

public interface JwtService {
    String generateToken(User user);
    boolean validateToken(String token);
    String extractUsername(String token);
    Map<String, Object> extractClaims(String token);
}