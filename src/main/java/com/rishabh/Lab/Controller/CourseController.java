package com.rishabh.Lab.Controller;


import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserDto;
import com.rishabh.Lab.Service.Implementation.UserServiceImpl;
import com.rishabh.Lab.Service.Interfaces.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {


    @Autowired
    CourseService courseService;

    @Autowired
    UserServiceImpl userServiceImpl;

//    @PostMapping
//    public CourseDto addCourse(@RequestBody CourseDto courseDto) throws Exception {
//
//        CourseDto courseDto1 = courseService.AddCourse(courseDto);
//
//        return courseDto1;
//    }

//    @GetMapping
//    public List<UserDto> getUser() throws Exception {
//        return userServiceImpl.getUser();
//    }

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) throws Exception {
        return courseService.addCourse(courseDto);
    }

    @PutMapping("/{id}")
    public CourseDto updateCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) throws Exception {
        return courseService.updateCourse(courseDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }


}
