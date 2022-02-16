package com.sysmap.mslearningcourse.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateCourseResult {
    private UUID courseId;
}
