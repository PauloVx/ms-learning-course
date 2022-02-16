package com.sysmap.mslearningcourse.repositories;

import com.sysmap.mslearningcourse.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends MongoRepository<Course, UUID> {
}
