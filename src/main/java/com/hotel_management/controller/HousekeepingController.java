package com.hotel_management.controller;

import com.hotel_management.entity.Housekeeping;
import com.hotel_management.service.HousekeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/housekeeping")
public class HousekeepingController {

    @Autowired
    private HousekeepingService housekeepingService;

    @PostMapping
    public ResponseEntity<Housekeeping> createHousekeepingTask(@RequestBody Housekeeping housekeeping) {
        Housekeeping createdTask = housekeepingService.createHousekeepingTask(housekeeping);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Housekeeping> getHousekeepingTask(@PathVariable Long taskId) {
        Housekeeping task = housekeepingService.getHousekeepingTaskById(taskId);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Housekeeping> updateHousekeepingTask(@PathVariable Long taskId, @RequestBody Housekeeping taskDetails) {
        Housekeeping updatedTask = housekeepingService.updateHousekeepingTask(taskId, taskDetails);
        return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteHousekeepingTask(@PathVariable Long taskId) {
        housekeepingService.deleteHousekeepingTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Housekeeping>> listHousekeepingTasks() {
        List<Housekeeping> tasks = housekeepingService.listHousekeepingTasks();
        return ResponseEntity.ok(tasks);
    }
}
