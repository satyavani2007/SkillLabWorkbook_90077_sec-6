package com.example.studentmanagement.service;

import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Student Service Class
 * Contains business logic for student management
 */
@Service
public class StudentService {
    
    // Dummy student data
    private final Map<Long, Student> studentDatabase = new HashMap<>();
    
    public StudentService() {
        // Initialize with dummy data
        studentDatabase.put(1L, new Student(1L, "Sai", "CSE"));
        studentDatabase.put(2L, new Student(2L, "Rahul", "ECE"));
        studentDatabase.put(3L, new Student(3L, "Priya", "IT"));
    }
    
    /**
     * Get student by ID
     * 
     * @param id the student ID
     * @return Student object if found
     * @throws StudentNotFoundException if student not found
     */
    public Student getStudentById(Long id) {
        return studentDatabase.getOrDefault(id, null) != null 
            ? studentDatabase.get(id)
            : null;
    }
    
    /**
     * Check if student exists
     * 
     * @param id the student ID
     * @return true if student exists, false otherwise
     */
    public boolean studentExists(Long id) {
        return studentDatabase.containsKey(id);
    }
}
