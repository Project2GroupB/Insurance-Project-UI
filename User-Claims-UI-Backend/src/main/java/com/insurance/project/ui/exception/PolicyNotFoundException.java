package com.insurance.project.ui.exception;

/*
 * Custom Exception for handling No Claims Found errors.
 */
public class PolicyNotFoundException extends RuntimeException {
    
    public PolicyNotFoundException(String message) {
        super(message);
    }
}
