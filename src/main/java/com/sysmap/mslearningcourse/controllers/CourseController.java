package com.sysmap.mslearningcourse.controllers;

import com.sysmap.mslearningcourse.entities.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @PostMapping
    public ResponseEntity<String> createCourse(
        @RequestBody
        String courseName
    ) {
        return null;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getcourse(
        @PathVariable
        UUID courseId
    ) {
        return null;
    }
}
