package com.rishabh.Lab;


import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Repository.UserDetailRepository;
import com.rishabh.Lab.Service.Implementation.AuthenticateUserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class AuthenticateUser_Test {

    ModelMapper modelMapper;
    UserDetailRepository userDetailRepository;
    AuthenticateUserImpl authenticateUser;
    @BeforeEach
    void setup()
    {
        UserDetailRepository userDetail=mock(UserDetailRepository.class);
        this.modelMapper=new ModelMapper();
        this.authenticateUser=new AuthenticateUserImpl(modelMapper,userDetail);
    }

    @Test
    void TestService()
    {
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
        UserRegisterDto userRegisterDto = new UserRegisterDto("john_doe", "john@example.com", "password123", "John", "Doe", createdAt, updatedAt);

        UserRegisterDto savedUser = authenticateUser.Register(userRegisterDto);

        Assertions.assertEquals(userRegisterDto.getUsername(),savedUser.getUsername());
        Assertions.assertEquals(userRegisterDto.getPasswordHash(),savedUser.getPasswordHash());
        Assertions.assertEquals(userRegisterDto.getCreatedAt(),savedUser.getCreatedAt());
        Assertions.assertEquals(userRegisterDto.getLastname(),savedUser.getLastname());
        Assertions.assertEquals(userRegisterDto.getFirstname(),savedUser.getFirstname());
        Assertions.assertEquals(userRegisterDto.getEmail(),savedUser.getEmail());
        Assertions.assertEquals(userRegisterDto.getUpdatedAt(),savedUser.getUpdatedAt());



    }
}
