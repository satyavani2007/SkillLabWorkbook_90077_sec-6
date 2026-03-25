package com.example.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.courseapi.entity.Course;
import com.example.courseapi.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course saved = service.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {

        Course course = service.getCourseById(id);

        if (course == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {

        Course existing = service.getCourseById(id);

        if (existing == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        course.setCourseId(id);
        return new ResponseEntity<>(service.updateCourse(course), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        Course existing = service.getCourseById(id);

        if (existing == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        service.deleteCourse(id);

        return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
    }

    // SEARCH BY TITLE
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {

        List<Course> list = service.searchByTitle(title);

        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}