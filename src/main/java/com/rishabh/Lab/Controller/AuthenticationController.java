package com.rishabh.Lab.Controller;


import com.rishabh.Lab.DTO.CourseDto;
import com.rishabh.Lab.DTO.UserLoginDto;
import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Entity.User;
import com.rishabh.Lab.Service.Interfaces.AuthenticateUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Getter
@Setter
@RequestMapping("/Auth")
public class AuthenticationController {

    AuthenticateUser authenticateUser;
    @PostMapping("/register")
    public ResponseEntity<UserRegisterDto> Register(@RequestBody UserRegisterDto userRegisterDto)
    {
        UserRegisterDto response = authenticateUser.Register(userRegisterDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getRegisterUser() throws Exception {
        List<User> response = authenticateUser.getUser();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody UserLoginDto userLoginDto)
    {
        String response = authenticateUser.Login(userLoginDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
