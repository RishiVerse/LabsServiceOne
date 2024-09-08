package com.rishabh.Lab.Controller;


import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.Repository.CourseRepository;
import com.rishabh.Lab.Service.Interfaces.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@NoArgsConstructor
@RestController
public class CourseController {


    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public CourseDto addCourse(@RequestBody CourseDto courseDto) throws Exception {

        CourseDto courseDto1 = courseService.AddCourse(courseDto);


        return courseDto1;
    }

}
