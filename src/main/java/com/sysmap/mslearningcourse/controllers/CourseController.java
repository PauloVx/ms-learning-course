package com.sysmap.mslearningcourse.controllers;

import com.sysmap.mslearningcourse.controllers.models.CreateCourseInput;
import com.sysmap.mslearningcourse.entities.Course;
import com.sysmap.mslearningcourse.services.CourseService;
import com.sysmap.mslearningcourse.services.models.CreateCourseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(
        CourseService courseService
    ) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CreateCourseResult> createCourse(
        @RequestBody
        CreateCourseInput input
    ) {
        if(input.getCourseName().length() <= 3) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        var dbResult = this.courseService.createCourse(input);
        if(dbResult == null) return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

        return new ResponseEntity<>(
        dbResult,
        HttpStatus.CREATED
        );
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getcourse(
        @PathVariable
        UUID courseId
    ) {
        return null;
    }
}
