package com.insurance.project.ui.exception;

/*
 * Custom Exception for handling No Claims Found errors.
 */
public class ClaimsNotFoundException extends RuntimeException {
    
    public ClaimsNotFoundException(String message) {
        super(message);
    }
}
