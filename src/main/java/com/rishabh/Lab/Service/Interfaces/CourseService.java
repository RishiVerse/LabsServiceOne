package com.rishabh.Lab.Service.Interfaces;

import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserRegisterDto;

public interface CourseService {

    public CourseDto AddCourse(CourseDto courseDto) throws Exception;
    public CourseDto getCourse();


}
