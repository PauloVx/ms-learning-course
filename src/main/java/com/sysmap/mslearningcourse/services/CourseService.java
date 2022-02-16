package com.sysmap.mslearningcourse.services;

import com.sysmap.mslearningcourse.controllers.models.CreateCourseInput;
import com.sysmap.mslearningcourse.entities.Course;
import com.sysmap.mslearningcourse.repositories.CourseRepository;
import com.sysmap.mslearningcourse.services.models.CreateCourseResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(
        CourseRepository courseRepository
    ) {
        this.courseRepository = courseRepository;
    }

    public CreateCourseResult createCourse(CreateCourseInput courseInput) {
        if(this.courseRepository.findCourseByCourseName(courseInput.getCourseName()).isPresent()) return null;

        var course = new Course(
            UUID.randomUUID(),
            courseInput.getCourseName(),
            true,
            LocalDateTime.now()
        );

        var dbResult = this.courseRepository.insert(course);

        return new CreateCourseResult(dbResult.getCourseId());
    }
}
