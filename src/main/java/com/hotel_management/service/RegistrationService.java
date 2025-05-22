package com.hotel_management.service;

import com.hotel_management.dto.UserRegistrationDTO;
import com.hotel_management.entity.User;
import com.hotel_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RegistrationService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(UserRegistrationDTO registrationDTO) {


        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setEmail(registrationDTO.getEmail());
        user.setRole(registrationDTO.getRole());

        // Optionally set other user properties here

        return userRepository.save(user);
    }


    public Boolean checkIfUsernameExist(UserRegistrationDTO registrationDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(registrationDTO.getUsername());

        // Check if the user exists
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Match the raw password with the encoded password stored in the database
            return passwordEncoder.matches(registrationDTO.getPassword(), user.getPassword()); // Return true if login is successful
        }

        return false; // Return false if the user is not found or the password does not match
    }

}
