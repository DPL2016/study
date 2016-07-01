package com.kaishengit.exception;

public class UserDaoServiceException extends RuntimeException {
    public UserDaoServiceException() {
    }

    public UserDaoServiceException(String message) {
        super(message);
    }
}
