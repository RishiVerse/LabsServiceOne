package com.rishabh.Lab.Service.Implementation;

import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Entity.Course;
import com.rishabh.Lab.Entity.User;
import com.rishabh.Lab.Repository.CourseRepository;
import com.rishabh.Lab.Repository.UserDetailRepository;
import com.rishabh.Lab.Service.Interfaces.AuthenticateUser;
import com.rishabh.Lab.Service.Interfaces.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    ModelMapper modelMapper;
    CourseRepository courseRepository;
    UserDetailRepository user;
    @Override
    public CourseDto AddCourse(CourseDto courseDto) throws Exception {

        String username=courseDto.getInstructorUsername().getUsername();

        if(user.findByUsername(username).isEmpty())
        {
            throw new Exception("Username Does not Exist , Please Register yourself first than try again");
        }
        else {



            CourseDto course = new CourseDto.CourseBuilder()
                                 .setCourseId(courseDto.getCourseId())
                                 .setInstructorUsername(courseDto.getInstructorUsername())
                                 .setCourseName(courseDto.getCourseName())
                                 .setDescription(courseDto.getDescription())
                                 .setCreatedAt(courseDto.getCreatedAt())
                                 .setLesson(courseDto.getLesson())
                                 .setUpdatedAt(courseDto.getUpdatedAt())
                                 .build();


            courseRepository.save(modelMapper.map(course, Course.class));
            return course;
        }
    }

    @Override
    public CourseDto getCourse() {
        List<Course> courses=courseRepository.findAll();
        return modelMapper.map(courses, CourseDto.class);
    }
}
