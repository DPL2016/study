package com.kaishengit.exception;

public class DataAccessException extends RuntimeException {
    public DataAccessException() {
    }

    public DataAccessException(String message) {
        super(message);
    }
    public DataAccessException(String message,Exception e) {
        super(message,e);
    }
}
