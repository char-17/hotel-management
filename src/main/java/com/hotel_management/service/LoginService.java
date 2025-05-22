package com.hotel_management.service;

import com.hotel_management.dto.LoginRequestDTO;
import com.hotel_management.dto.LoginResponseDTO;
import com.hotel_management.entity.User;
import com.hotel_management.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginResponseDTO login(LoginRequestDTO loginDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Optional<User> user = loginRepository.findByUsername(loginDTO.getUsername());
        Boolean found = user.map(optionalUser -> passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword()))
                .orElse(false);


        return getLoginResponseDTO(found, user);
    }

    private static LoginResponseDTO getLoginResponseDTO(Boolean found, Optional<User> user) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

        if (found) {
            loginResponseDTO.setLoginStatus(true);
            loginResponseDTO.setRegistrationErrorMessage("Login successful");
        }
        else if (user.isEmpty()) {
            loginResponseDTO.setLoginStatus(false);
            loginResponseDTO.setRegistrationErrorMessage("Login failed");
        }
        else {
            loginResponseDTO.setLoginStatus(false);
            loginResponseDTO.setRegistrationErrorMessage("Login failed");
        }
        return loginResponseDTO;
    }
}