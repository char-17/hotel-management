package com.hotel_management.service;

import com.hotel_management.dtoRequestResponse.UserRegisterRequestDTO;
import com.hotel_management.model.User;
import com.hotel_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public User registerNewUser(UserRegisterRequestDTO registrationDTO) {

        LocalDate today = LocalDate.now();
        User user = new User();
        user.setLastName(registrationDTO.getLastName());
        user.setFirstName(registrationDTO.getUsername());
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setEmail(registrationDTO.getEmail());
        user.setRole(registrationDTO.getRole());
        user.setGender(registrationDTO.getGender());
        user.setDateOfBirth(registrationDTO.getDateOfBirth());
        System.out.println("Today's date is: " + today);

        // Optionally set other user properties here

        return userRepository.save(user);
    }


    public Boolean checkIfUsernameExist(UserRegisterRequestDTO registrationDTO) {
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
