package com.hotel_management.controller;


import com.hotel_management.model.Reservation;
import com.hotel_management.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create_reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        return reservation != null ? ResponseEntity.ok(reservation) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long reservationId, @RequestBody Reservation reservationDetails) {
        Reservation updatedReservation = reservationService.updateReservation(reservationId, reservationDetails);
        return updatedReservation != null ? ResponseEntity.ok(updatedReservation) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all_reservations")
    public ResponseEntity<List<Reservation>> listReservations() {
        List<Reservation> reservations = reservationService.listReservations();
        return ResponseEntity.ok(reservations);
    }
}
