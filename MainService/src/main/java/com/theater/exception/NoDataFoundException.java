package com.theater.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super("No Data Found");
    }
}
