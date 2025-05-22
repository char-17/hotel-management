package com.hotel_management.controller;

import org.springframework.web.bind.annotation.*;
import com.hotel_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class RoomServiceController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomService> createRoomService(@RequestBody RoomService roomService) {
//        RoomService createRoomService = roomService.createRoom();
        // TO DO
//        Something get wrong with Service as ServiceService and RoomService and some
//                RoomServiceService
        return null;
    }
}
