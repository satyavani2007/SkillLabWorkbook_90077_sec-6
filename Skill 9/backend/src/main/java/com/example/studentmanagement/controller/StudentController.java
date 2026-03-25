package com.example.studentmanagement.controller;

import com.example.studentmanagement.exception.InvalidInputException;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Student REST Controller
 * Handles HTTP requests related to students
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    /**
     * Get student by ID endpoint
     * 
     * @param id the student ID from path variable
     * @return ResponseEntity with Student data if found
     * @throws StudentNotFoundException if student not found
     * @throws InvalidInputException if input is invalid
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        
        // Validate input - check if id is a valid number
        Long studentId;
        try {
            studentId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input: Student ID must be a valid number. Received: " + id);
        }
        
        // Validate that ID is positive
        if (studentId <= 0) {
            throw new InvalidInputException("Invalid input: Student ID must be a positive number. Received: " + studentId);
        }
        
        // Check if student exists
        if (!studentService.studentExists(studentId)) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
        
        // Get and return the student
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
