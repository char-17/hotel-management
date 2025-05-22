package com.hotel_management.exceptions;

public class MyResourceNotFoundException extends RuntimeException{
    public MyResourceNotFoundException(String message){
        super(message);
    }
}
