package com.theater;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super("No Data Found");
    }
}
