package com.hotel_management.controller;

import com.hotel_management.dto.LoginRequestDTO;
import com.hotel_management.dto.LoginResponseDTO;
import com.hotel_management.dto.UserRegistrationDTO;
import com.hotel_management.entity.User;
import com.hotel_management.service.LoginService;
import com.hotel_management.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class AuthController {


    private final RegistrationService userRegistrationService;
    private final LoginService loginService;

    public AuthController(RegistrationService userRegistrationService, LoginService loginService) {
        this.userRegistrationService = userRegistrationService;
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationDTO> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        Boolean user = userRegistrationService.checkIfUsernameExist(registrationDTO);

        if (!user) {
            User newuser = userRegistrationService.registerNewUser(registrationDTO);
            registrationDTO.setRegistrationErrorMessage("Registered Successfully");
        } else {

            registrationDTO.setRole(null);
            registrationDTO.setUsername(null);
            registrationDTO.setPassword(null);
            registrationDTO.setEmail(null);
            registrationDTO.setRegistrationErrorMessage("Username already exists in the system choose another one!");
            return ResponseEntity.ok(registrationDTO);
        }
        return ResponseEntity.ok(registrationDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}

