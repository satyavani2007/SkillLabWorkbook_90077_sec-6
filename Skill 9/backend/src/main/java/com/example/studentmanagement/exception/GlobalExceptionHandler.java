package com.example.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Global Exception Handler Class
 * Centralized exception handling for the entire application using @ControllerAdvice
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    
    /**
     * Handle StudentNotFoundException
     * Returns 404 status with error details
     * 
     * @param exception the StudentNotFoundException
     * @return ResponseEntity with error response and 404 status
     */
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception) {
        
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now().format(formatter),
            exception.getMessage(),
            HttpStatus.NOT_FOUND.value()
        );
        
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(errorResponse);
    }
    
    /**
     * Handle InvalidInputException
     * Returns 400 status with error details
     * 
     * @param exception the InvalidInputException
     * @return ResponseEntity with error response and 400 status
     */
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException exception) {
        
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now().format(formatter),
            exception.getMessage(),
            HttpStatus.BAD_REQUEST.value()
        );
        
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorResponse);
    }
    
    /**
     * Handle all other generic exceptions
     * Returns 500 status with error details
     * 
     * @param exception the generic Exception
     * @return ResponseEntity with error response and 500 status
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now().format(formatter),
            "An unexpected error occurred: " + exception.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorResponse);
    }
}
