package com.example.studentmanagement.exception;

/**
 * Custom Exception for Student Not Found
 * This exception is thrown when a student with the specified ID is not found
 */
public class StudentNotFoundException extends RuntimeException {
    
    public StudentNotFoundException(String message) {
        super(message);
    }
    
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public StudentNotFoundException(Long studentId) {
        super("Student not found with ID: " + studentId);
    }
}
