package com.telemedicine.telemedicine_backend.service;

import com.telemedicine.telemedicine_backend.dto.LoginRequestDTO;
import com.telemedicine.telemedicine_backend.dto.LoginResponseDTO;
import com.telemedicine.telemedicine_backend.entity.Admin;
import com.telemedicine.telemedicine_backend.repository.AdminRepository;
import com.telemedicine.telemedicine_backend.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(AdminRepository adminRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        Admin admin = adminRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(admin.getUsername());

        return new LoginResponseDTO(token, admin.getUsername(), "Login successful");
    }

    public void registerAdmin(String username, String rawPassword) {
        if (adminRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Admin already exists with username: " + username);
        }
        Admin admin = new Admin(username, passwordEncoder.encode(rawPassword));
        adminRepository.save(admin);
    }
}