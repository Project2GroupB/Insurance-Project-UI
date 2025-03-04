package com.insurance.project.ui.exception;

/*
 * Custom Exception for handling User Not Found errors.
 */
public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
