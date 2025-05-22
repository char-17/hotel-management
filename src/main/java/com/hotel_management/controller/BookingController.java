package com.hotel_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hotel_management.service.BookingService;
import com.hotel_management.entity.Booking;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}
