package com.hotel_management.model.enums;

public enum UserRole {
    ADMIN(1),
    MANAGER(2),
    STAFF(3),
    CLIENT(4),
    GUEST(5);

    private final int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
