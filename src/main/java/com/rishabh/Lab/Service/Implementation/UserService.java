package com.rishabh.Lab.Service.Implementation;

import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Entity.User;
import com.rishabh.Lab.Repository.UserDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserDetailRepository userDetailRepository;
    ModelMapper modelMapper;

    public UserService(UserDetailRepository userDetailRepository, ModelMapper modelMapper) {
        this.userDetailRepository = userDetailRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserRegisterDto> getUser() {
        List<User> users = userDetailRepository.findAll();  // Fetch all users
        return users.stream()
                .map(user -> modelMapper.map(user, UserRegisterDto.class))  // Map each User to UserRegisterDto
                .collect(Collectors.toList());  // Collect as a list
    }

}
