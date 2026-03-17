package com.telemedicine.telemedicine_backend.controller;

import com.telemedicine.telemedicine_backend.dto.ApiResponse;
import com.telemedicine.telemedicine_backend.dto.LoginRequestDTO;
import com.telemedicine.telemedicine_backend.dto.LoginResponseDTO;
import com.telemedicine.telemedicine_backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(
            @RequestBody LoginRequestDTO request) {
        LoginResponseDTO loginResponse = authService.login(request);
        ApiResponse<LoginResponseDTO> response = new ApiResponse<>(true, loginResponse);
        return ResponseEntity.ok(response);
    }
}