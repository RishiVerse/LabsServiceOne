package com.rishabh.Lab.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonDto {

    private Long lessonId;
    private String lessonTitle;
    private Long courseId;
    private String content;

}
