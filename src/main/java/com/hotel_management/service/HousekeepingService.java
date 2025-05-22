package com.hotel_management.service;


import com.hotel_management.entity.Housekeeping;
import com.hotel_management.repository.HousekeepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousekeepingService {

    @Autowired
    private HousekeepingRepository housekeepingRepository;

    public Housekeeping createHousekeepingTask(Housekeeping housekeeping) {
        return housekeepingRepository.save(housekeeping);
    }

    public Housekeeping getHousekeepingTaskById(Long taskId){
        Optional<Housekeeping> housekeeping = housekeepingRepository.findById(taskId);
        return housekeeping.orElse(null);
    }

    public Housekeeping updateHousekeepingTask(Long taskId, Housekeeping housekeepingDetails) {
        Housekeeping housekeeping = getHousekeepingTaskById(taskId);
        if (housekeeping != null) {
            housekeeping.setTaskDate(housekeepingDetails.getTaskDate());
            housekeeping.setTaskDescription(housekeepingDetails.getTaskDescription());
            housekeeping.setStatus(housekeepingDetails.getStatus());
            housekeeping.setRoom(housekeepingDetails.getRoom());
            housekeeping.setEmployee(housekeepingDetails.getEmployee());
            return housekeepingRepository.save(housekeeping);
        }
        return null;
    }

    public void deleteHousekeepingTask(Long taskId) {
        housekeepingRepository.deleteById(taskId);
    }

    public List<Housekeeping> listHousekeepingTasks() {
        return housekeepingRepository.findAll();
    }
}
