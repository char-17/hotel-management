package com.hotel_management.dtoRequestResponse;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UserRegisterRequestDTO {
//    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String gender;
    private Integer role=3;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        System.out.println("date of birth in Request object"+ dateOfBirth);
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
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


    /**
     * Return true if all required fields are null or blank.
     */
    public boolean isEmpty(){
        // check username
        boolean usernameEmpty = (username == null || username.trim().isEmpty());
        // check password
        boolean passwordEmpty = (password == null || password.trim().isEmpty());
        // check email
        boolean emailEmpty    = (email    == null || email.trim().isEmpty());
        // check role
        boolean roleEmpty     = (role     == null);
        return usernameEmpty && passwordEmpty && emailEmpty && roleEmpty;
    }
}
