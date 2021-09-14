package com.theater;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String name) {
        super(String.format("Movie with Name %d not found", name));
    }

    public MovieNotFoundException(Long id) {
        super(String.format("Movie with Id %d not found", id));
    }

}
