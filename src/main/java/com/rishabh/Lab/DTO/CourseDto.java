package com.rishabh.Lab.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Integer courseId;
    private String courseName;
    private String description;
//    private Timestamp createdAt;
//    private Timestamp updatedAt;
    private UserDto instructorUsername;
    private Set<LessonDto> lessons;
}
