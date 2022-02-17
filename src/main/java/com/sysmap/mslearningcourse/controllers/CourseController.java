package com.sysmap.mslearningcourse.controllers;

import com.sysmap.mslearningcourse.controllers.models.CreateCourseInput;
import com.sysmap.mslearningcourse.services.CourseService;
import com.sysmap.mslearningcourse.services.models.CreateCourseResult;
import com.sysmap.mslearningcourse.services.models.GetCourseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class CourseController {

    private CourseService courseService;

    public CourseController(
        CourseService courseService
    ) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
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


    @GetMapping({"/courses", "/courses/{courseId}"})
    public ResponseEntity<List<GetCourseResult>> getOneCourse(
        @PathVariable("courseId")
        Optional<String> courseId
    ) {
        return courseId.map(uuid -> new ResponseEntity<>(
            List.of(this.courseService.getOneCourse(UUID.fromString(uuid))),
            HttpStatus.OK
        )).orElseGet(() -> new ResponseEntity<>(
            this.courseService.getAllCourses(),
            HttpStatus.OK
        ));

    }
}
