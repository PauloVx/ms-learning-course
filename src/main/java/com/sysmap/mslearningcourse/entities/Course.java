package com.sysmap.mslearningcourse.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Document
public class Course {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID courseId;

    private String courseName;
    private Boolean status;
    private LocalDateTime createdOn;

    public Course(
        UUID courseId,
        String courseName,
        Boolean status,
        LocalDateTime createdOn
    ) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
        this.createdOn = createdOn;
    }
}
