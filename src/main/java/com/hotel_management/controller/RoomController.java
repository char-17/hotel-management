package com.hotel_management.controller;

import com.hotel_management.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel_management.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        return ResponseEntity.ok(createdRoom);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoom(@PathVariable Long roomId) {
        Room room = roomService.getRoomById(roomId);
        return room != null ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomId, @RequestBody Room roomDetails) {
        Room updatedRoom = roomService.updateRoom(roomId, roomDetails);
        return updatedRoom != null ? ResponseEntity.ok(updatedRoom) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Room>> listRooms() {
        List<Room> rooms = roomService.listRooms();
        return ResponseEntity.ok(rooms);
    }
}