package com.rishabh.Lab.Service.Interfaces;

import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserRegisterDto;

import java.util.List;

public interface CourseService {

    CourseDto addCourse(CourseDto courseDto) throws Exception;

    CourseDto updateCourse(CourseDto courseDto, Integer courseId) throws Exception;

    void deleteCourse(Integer courseId);

    CourseDto getCourse(Integer courseId);

    List<CourseDto> getAllCourses();
}
