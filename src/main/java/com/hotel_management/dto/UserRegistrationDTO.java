package com.hotel_management.dto;

public class UserRegistrationDTO {
    private Long id;

    private String username;
    private String password;
    private Integer role;
    private String email;
    private String registrationErrorMessage;

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRegistrationErrorMessage() {
        return registrationErrorMessage;
    }

    public void setRegistrationErrorMessage(String registrationErrorMessage) {
        this.registrationErrorMessage = registrationErrorMessage;
    }
}
