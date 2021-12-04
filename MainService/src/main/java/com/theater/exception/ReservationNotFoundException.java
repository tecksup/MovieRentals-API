package com.theater.exception;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(String name) {
        super(String.format("Reservation with Name %d not found", name));
    }

    public ReservationNotFoundException(Long id) {
        super(String.format("Reservation with Id %d not found", id));
    }

}
