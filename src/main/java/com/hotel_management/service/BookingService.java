package com.hotel_management.service;

import com.hotel_management.entity.Booking;
import com.hotel_management.entity.Room;
import com.hotel_management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel_management.repository.BookingRepository;
import com.hotel_management.repository.RoomRepository;
import com.hotel_management.repository.UserRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking){
        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepository.findById(booking.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setRoom(room);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }
}
