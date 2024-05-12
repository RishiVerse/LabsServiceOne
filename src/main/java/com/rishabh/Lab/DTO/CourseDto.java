package com.rishabh.Lab.DTO;

import com.rishabh.Lab.Entity.Lesson;
import com.rishabh.Lab.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {

    private Long courseId;
    private String courseName;
    private User instructorUsername;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Set<Lesson> lesson;


}
