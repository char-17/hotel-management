package com.hotel_management.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Housekeeping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houskeepingId;


    private Date taskDate;
    private String taskDescription;
    private String status;

    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public Long getHouskeepingId() {
        return houskeepingId;
    }

    public void setHouskeepingId(Long houskeepingId) {
        this.houskeepingId = houskeepingId;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
