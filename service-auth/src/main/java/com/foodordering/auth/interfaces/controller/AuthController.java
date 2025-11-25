package com.foodordering.auth.interfaces.controller;

import com.foodordering.auth.application.dto.LoginRequestDto;
import com.foodordering.auth.application.dto.RegisterRequestDto;
import com.foodordering.auth.application.dto.UserResponseDto;
import com.foodordering.auth.application.mapper.UserMapper;
import com.foodordering.auth.application.usecase.LoginUseCase;
import com.foodordering.auth.application.usecase.RegisterUseCase;
import com.foodordering.auth.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {

    private final RegisterUseCase registerUseCase;
    private final LoginUseCase loginUseCase;
    private final UserMapper userMapper;

    public AuthController(RegisterUseCase registerUseCase,
                         LoginUseCase loginUseCase,
                         UserMapper userMapper) {
        this.registerUseCase = registerUseCase;
        this.loginUseCase = loginUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody RegisterRequestDto request) {
        User user = registerUseCase.execute(
            request.getEmail(),
            request.getPassword(),
            request.getFullName(),
            request.getRole()
        );
        UserResponseDto response = userMapper.toResponseDto(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequestDto request) {
        String token = loginUseCase.execute(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }
}