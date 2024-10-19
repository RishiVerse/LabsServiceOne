package com.rishabh.Lab.Service.Implementation;

import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.Entity.Course;
import com.rishabh.Lab.Repository.CourseRepo;
import com.rishabh.Lab.Repository.UserRepo;
import com.rishabh.Lab.Service.Interfaces.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    ModelMapper modelMapper;
    CourseRepo courseRepo;
    UserRepo user;

    @Override
    public CourseDto addCourse(CourseDto courseDto) throws Exception {
        Course course = modelMapper.map(courseDto, Course.class);
        courseRepo.save(course);
        return modelMapper.map(course, CourseDto.class);
    }


    @Override
    public CourseDto updateCourse(CourseDto courseDto, Integer courseId) throws Exception {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new Exception("Course not found"));

        course = modelMapper.map(courseDto, Course.class);
        course.setCourseId(courseId);
        courseRepo.save(course);
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        courseRepo.deleteById(courseId);
    }

    @Override
    public CourseDto getCourse(Integer courseId) {
        return modelMapper.map(courseRepo.findById(courseId).get(), CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepo.findAll().stream().map(course->modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
    }

}
