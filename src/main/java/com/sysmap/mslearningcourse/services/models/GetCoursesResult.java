package com.sysmap.mslearningcourse.services.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GetCoursesResult {
    private UUID courseId;
    private String courseName;
    private Boolean status;
    private LocalDateTime createdOn;
}
