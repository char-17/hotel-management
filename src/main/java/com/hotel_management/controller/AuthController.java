package com.hotel_management.controller;

import com.hotel_management.dtoRequestResponse.LoginRequestDTO;
import com.hotel_management.dtoRequestResponse.LoginResponseDTO;
import com.hotel_management.dtoRequestResponse.UserRegisterRequestDTO;
import com.hotel_management.dtoRequestResponse.UserRegisterResponseDTO;
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
    public ResponseEntity<UserRegisterResponseDTO> registerUser(@RequestBody UserRegisterRequestDTO request) {

        UserRegisterResponseDTO response = new UserRegisterResponseDTO();

        Boolean userExists = userRegistrationService.checkIfUsernameExist(request);

        if (!userExists && !request.isEmpty()) {
            userRegistrationService.registerNewUser(request);

            response.setUsername(request.getUsername());
            response.setFirstName(request.getFirstName());
            response.setLastName(request.getLastName());
            response.setEmail(request.getEmail());
            response.setPassword(request.getPassword());
            response.setRole(request.getRole());
            response.setDateOfBirth(request.getDateOfBirth());
            response.setGender(request.getGender());
            response.setRegistrationErrorMessage("Registration Successfully!");
        } else if (request.isEmpty()) {
            response.setRegistrationErrorMessage("Username already exists in the system choose another one!");
            return null;
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginDTO) {
        LoginResponseDTO response = new LoginResponseDTO();
        response = loginService.login(loginDTO);
        return ResponseEntity.ok(response);


    }
}

