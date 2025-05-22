package com.hotel_management.dto;

public class LoginResponseDTO {
    private Boolean loginStatus;
    private String registrationErrorMessage;

    public String getRegistrationErrorMessage() {
        return registrationErrorMessage;
    }

    public void setRegistrationErrorMessage(String registrationErrorMessage) {
        this.registrationErrorMessage = registrationErrorMessage;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
