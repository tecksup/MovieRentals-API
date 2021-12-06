package com.theater.exception;

public class MovieAlreadyReservedException extends RuntimeException {

    public MovieAlreadyReservedException(Long id) {
        super(String.format("Movie with Id %d already reserved", id));
    }

}
