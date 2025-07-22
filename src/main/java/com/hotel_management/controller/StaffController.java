package com.hotel_management.controller;

import com.hotel_management.exceptions.MyResourceNotFoundException;
import com.hotel_management.model.User;
import com.hotel_management.model.enums.UserRole;
import com.hotel_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllStaff() {
        return userRepository.findByRole(UserRole.STAFF.getValue());
    }

    @PostMapping
    public User createStaff(@RequestBody User user) {
        user.setRole(UserRole.STAFF.getValue());
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateStaff(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new MyResourceNotFoundException("Staff not found"));
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(UserRole.STAFF.getValue());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new MyResourceNotFoundException("Staff not found"));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
