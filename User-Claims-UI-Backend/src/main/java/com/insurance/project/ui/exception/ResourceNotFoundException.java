package com.insurance.project.ui.exception;

/*
 * Generic Custom Exception for handling resource not found errors.
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
