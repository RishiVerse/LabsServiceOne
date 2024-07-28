package com.rishabh.Lab.Controller;


import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Service.Interfaces.AuthenticateUser;
import com.rishabh.Lab.Service.Interfaces.CourseService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Getter
@Setter
@RequestMapping("/lecture")
public class LectureController {

    CourseService courseService;
    @PostMapping("/detail")
    public ResponseEntity<CourseDto> Register(@RequestBody CourseDto courseDto) throws Exception {
        CourseDto response = courseService.AddCourse(courseDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getdetail")
    public ResponseEntity<CourseDto> getCourses() throws Exception {
        CourseDto response = courseService.getCourse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}
