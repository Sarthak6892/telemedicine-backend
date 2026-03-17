package com.telemedicine.telemedicine_backend.dto;

public class LoginResponseDTO {

    private String token;
    private String username;
    private String message;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String token, String username, String message) {
        this.token = token;
        this.username = username;
        this.message = message;
    }

    public String getToken() { return token; }
    public String getUsername() { return username; }
    public String getMessage() { return message; }

    public void setToken(String token) { this.token = token; }
    public void setUsername(String username) { this.username = username; }
    public void setMessage(String message) { this.message = message; }
}