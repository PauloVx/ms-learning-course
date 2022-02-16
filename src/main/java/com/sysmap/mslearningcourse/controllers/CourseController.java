package com.sysmap.mslearningcourse.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
