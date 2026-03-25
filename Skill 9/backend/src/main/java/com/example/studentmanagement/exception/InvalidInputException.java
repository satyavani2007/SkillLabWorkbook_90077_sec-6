package com.example.studentmanagement.exception;

/**
 * Custom Exception for Invalid Input
 * This exception is thrown when invalid input is provided (e.g., text instead of number)
 */
public class InvalidInputException extends RuntimeException {
    
    public InvalidInputException(String message) {
        super(message);
    }
    
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
