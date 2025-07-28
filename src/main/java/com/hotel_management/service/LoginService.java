package com.hotel_management.service;

import com.hotel_management.dtoRequestResponse.LoginRequestDTO;
import com.hotel_management.dtoRequestResponse.LoginResponseDTO;
import com.hotel_management.model.User;
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
        LoginResponseDTO response = new LoginResponseDTO();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Optional<User> userOptional = loginRepository.findByUsername(loginDTO.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // An vrikame ton xristi
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
                response.setUsername(user.getUsername());
                response.setPassword("found");
                response.setLoginStatus(true);
                return response;
            }
        }

        // Efoson o xristis den exei vrethei
        response.setUsername("null");
        response.setPassword("null");
        response.setLoginStatus(false);
        return response;
    }


//    private static LoginResponseDTO getLoginResponseDTO(Boolean found, Optional<User> user) {
//        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
//
//        if (found) {
//            loginResponseDTO.setLoginStatus(true);
//            loginResponseDTO.setLoginMessage("Login successful");
//        }
//        else if (user.isEmpty()) {
//            loginResponseDTO.setLoginStatus(false);
//            loginResponseDTO.setLoginMessage("Login failed");
//        }
//        else {
//            loginResponseDTO.setLoginStatus(false);
//            loginResponseDTO.setLoginMessage("Login failed");
//        }
//        return loginResponseDTO;
//    }
}