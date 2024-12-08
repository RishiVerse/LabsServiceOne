package com.rishabh.Lab.Controller;

import com.rishabh.Lab.DTO.UserDto;
import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Service.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserDto> getUser() throws Exception {
        return userServiceImpl.getUser();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) throws Exception {
        return userServiceImpl.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userServiceImpl.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        return userServiceImpl.updateUser(id,userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userServiceImpl.deleteUser(id);
    }
}
