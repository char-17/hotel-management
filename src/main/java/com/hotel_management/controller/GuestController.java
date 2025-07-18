package com.hotel_management.controller;

import com.hotel_management.entity.User;
import com.hotel_management.entity.enums.UserRole;
import com.hotel_management.repository.UserRepository;
import com.hotel_management.exceptions.MyResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/guests")
@CrossOrigin(origins = "http://localhost:4200")
public class GuestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllGuests() {
        return userRepository.findByRole(UserRole.GUEST.getValue());
    }

    @PostMapping("/api/auth/create_guest")
    public User createGuest(@RequestBody User user) {
        user.setRole(UserRole.GUEST.getValue());
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateGuest(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new MyResourceNotFoundException("Guest not found"));
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(UserRole.GUEST.getValue());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuest(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new MyResourceNotFoundException("Guest not found"));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
