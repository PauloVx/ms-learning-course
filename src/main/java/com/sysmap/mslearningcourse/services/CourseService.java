package com.sysmap.mslearningcourse.services;

import com.sysmap.mslearningcourse.controllers.models.CreateCourseInput;
import com.sysmap.mslearningcourse.entities.Course;
import com.sysmap.mslearningcourse.repositories.CourseRepository;
import com.sysmap.mslearningcourse.services.models.CreateCourseResult;
import com.sysmap.mslearningcourse.services.models.GetCourseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public List<GetCourseResult> getAllCourses() {
        List<Course> courses = this.courseRepository.findAll();
        List<GetCourseResult> courseResults = new ArrayList<>();

        for (var course : courses) {
            GetCourseResult courseResult = new GetCourseResult();
            BeanUtils.copyProperties(course, courseResult);

            courseResults.add(courseResult);
        }

        return courseResults;
    }

    public GetCourseResult getOneCourse(UUID courseId) {
        Course course = this.courseRepository.findCourseByCourseId(courseId).get();

        GetCourseResult courseResult = new GetCourseResult();
        BeanUtils.copyProperties(course, courseResult);

        return courseResult;
    }
}
