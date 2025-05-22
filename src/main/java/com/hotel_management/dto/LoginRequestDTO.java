package com.hotel_management.dto;

public class LoginRequestDTO {
    private String username;
    private String password;
    private String loginRequestError;

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

    public String getLoginRequestError() {
        return loginRequestError;
    }

    public void setLoginRequestError(String loginRequestError) {
        this.loginRequestError = loginRequestError;
    }
}
