package com.telemedicine.telemedicine_backend.config;

import com.telemedicine.telemedicine_backend.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner createDefaultAdmin(AuthService authService) {
        return args -> {
            try {
                authService.registerAdmin("admin", "admin123");
                System.out.println("Default admin created — username: admin, password: admin123");
            } catch (RuntimeException e) {
                System.out.println("Admin already exists, skipping creation.");
            }
        };
    }
}