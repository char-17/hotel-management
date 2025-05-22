package com.hotel_management.service;

import com.hotel_management.entity.Employee;
import com.hotel_management.entity.Room;
import com.hotel_management.exceptions.MyResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel_management.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.orElse(null);
    }

    public Room updateRoom(Long roomId, Room roomDetails) {
        Room room = getRoomById(roomId);
        if (room != null) {
            room.setRoomNumber(roomDetails.getRoomNumber());
            room.setRoomType(roomDetails.getRoomType());
            room.setCapacity(roomDetails.getCapacity());
            room.setRoomPrice(roomDetails.getRoomPrice());
            room.setRoomStatus(roomDetails.getRoomStatus());
            return roomRepository.save(room);
        }
        return null;
    }

    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    public List<Room> listRooms() {
        return roomRepository.findAll();
    }
}
