package com.example.studentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * Welcome REST Controller
 * Provides welcome message and API information
 */
@RestController
public class WelcomeController {
    
    /**
     * Welcome endpoint
     * 
     * @return Welcome message with API information
     */
    @GetMapping("/")
    public Map<String, Object> welcome() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Student Management System");
        response.put("version", "1.0.0");
        response.put("java_version", System.getProperty("java.version"));
        response.put("available_endpoints", new String[]{
            "GET /students/{id} - Get student by ID",
            "POST /students - Create a new student",
            "PUT /students/{id} - Update a student",
            "DELETE /students/{id} - Delete a student"
        });
        return response;
    }
}
