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

import java.util.HashSet;


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


            Course course = new Course(courseDto.getCourseId(), courseDto.getCourseName(),new User(), courseDto.getInstructorUsername().getUsername(),
                    courseDto.getCreatedAt(), courseDto.getUpdatedAt(), new HashSet<>());

            courseRepository.save(course);
            return modelMapper.map(course, CourseDto.class);
        }
    }
}
