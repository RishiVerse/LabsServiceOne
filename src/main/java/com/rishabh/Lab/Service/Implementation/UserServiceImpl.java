package com.rishabh.Lab.Service.Implementation;

import com.rishabh.Lab.DTO.UserDto;
import com.rishabh.Lab.Entity.User;
import com.rishabh.Lab.Repository.UserRepo;
import com.rishabh.Lab.Service.Interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getUser() {
        List<User> users = userRepo.findAll();  // Fetch all users
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))  // Map each User to UserRegisterDto
                .collect(Collectors.toList());  // Collect as a list
    }

    // Create a new user
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    // Read a user by ID
    public UserDto getUserById(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDto.class);
    }

    // Update a user
    public UserDto updateUser(Integer userId, UserDto userDto) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        modelMapper.map(userDto, existingUser);  // Update the existing user entity

        User updatedUser = userRepo.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    // Delete a user by ID
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

}
