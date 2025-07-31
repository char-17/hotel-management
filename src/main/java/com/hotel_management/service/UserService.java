package com.hotel_management.service;


import com.hotel_management.model.User;
import com.hotel_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //antloume olous tous xristes
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // Найти по username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
