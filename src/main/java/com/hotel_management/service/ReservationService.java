package com.hotel_management.service;

import com.hotel_management.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel_management.entity.Reservation;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return reservation.orElse(null);
    }

    public Reservation updateReservation(Long reservationId, Reservation reservationDetails) {
        Reservation reservation = getReservationById(reservationId);
        if (reservation != null) {
            reservation.setCheckInDate(reservationDetails.getCheckInDate());
            reservation.setCheckOutDate(reservationDetails.getCheckOutDate());
            reservation.setNumberOfGuests(reservationDetails.getNumberOfGuests());
            reservation.setStatus(reservationDetails.getStatus());
            reservation.setGuest(reservationDetails.getGuest());
            reservation.setRoom(reservationDetails.getRoom());
            return reservationRepository.save(reservation);
        }
        return null;
    }
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public List<Reservation> listReservations() {
        return reservationRepository.findAll();
    }
}
