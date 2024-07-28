package com.rishabh.Lab;

import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Entity.Course;
import com.rishabh.Lab.Entity.User;
import com.rishabh.Lab.Repository.CourseRepository;
import com.rishabh.Lab.Repository.UserDetailRepository;
import com.rishabh.Lab.Service.Implementation.AuthenticateUserImpl;
import com.rishabh.Lab.Service.Interfaces.AuthenticateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCourseServiceImpl {

    ModelMapper mockModelMapper=mock(ModelMapper.class);
    AuthenticationManager mockAuthenticationManager=mock(AuthenticationManager.class);
    UserDetailRepository mockUserDetailRepository = mock(UserDetailRepository.class);
    PasswordEncoder mockPasswordEncoder=mock(PasswordEncoder.class);



    @BeforeEach
    void setUp() {
        String createdAtStr = "2024-05-26 15:30:00";
        String updatedAtStr = "2024-05-26 15:30:00";

        Timestamp createdAt = Timestamp.valueOf(createdAtStr);
        Timestamp updatedAt = Timestamp.valueOf(updatedAtStr);

        User user = new User("rishabh", "h@g.com", "dadaw", "rosh", "m", createdAt, updatedAt, new HashSet<>());
        CourseDto courseDto = new CourseDto(1L, "Java", user, "jaa learn", createdAt, updatedAt, new HashSet<>());




        AuthenticateUserImpl authenticateUser=new AuthenticateUserImpl(mockModelMapper,mockUserDetailRepository,
                mockAuthenticationManager,mockPasswordEncoder);
        authenticateUser.Register(mockModelMapper.map(user,UserRegisterDto.class));
    }

//    @Test
//    void testAddCourse_UserNotFound() {
//
//
//
//        Optional<User> result = userDetailRepository.findByUsername(user.getUsername());
//
//        // Print the username and check if the user is not found
//        System.out.println(user.getUsername());
//        System.out.println(result.isPresent());
//
//        // Assert that the user was not found
//        assertFalse(result.isPresent());
//    }
}
