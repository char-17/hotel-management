package com.hotel_management.service;


import com.hotel_management.model.Guest;
import com.hotel_management.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest createGuest(Guest guest){
        return guestRepository.save(guest);
    }

    public Guest getGuestById(long guestId){
        Optional<Guest> guest = guestRepository.findById(guestId);
        return guest.orElse(null);
    }

    public Guest updateGuest(Long guestId, Guest guestDetails){
        Guest guest = getGuestById(guestId);
        if(guest !=null){
            guest.setFirstName(guestDetails.getFirstName());
            guest.setLastName(guestDetails.getLastName());
            guest.setEmail(guestDetails.getEmail());
            guest.setPhone(guestDetails.getPhone());
            guest.setAddress(guestDetails.getAddress());
            guest.setDateOfBirth(guestDetails.getDateOfBirth());
            return guestRepository.save(guest);
        }
        return null;
    }

    public void deleteGuest(Long guestId){
        guestRepository.deleteById(guestId);
    }

    public List<Guest> listGuest(){
        return guestRepository.findAll();
    }
}
