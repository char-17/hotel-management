package com.hotel_management.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private Date checkInDate;
    private Date checkOutDate;
    private Integer numberOfGuests;
    private String status;

    @ManyToOne
    @JoinColumn(name = "guestID")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "roomID")
    private Room room;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
