package com.rishabh.Lab.Service.Interfaces;

import com.rishabh.Lab.DTO.UserLoginDto;
import com.rishabh.Lab.DTO.UserRegisterDto;
import com.rishabh.Lab.Entity.User;

import java.util.List;
import java.util.Optional;

public interface AuthenticateUser {

    public UserRegisterDto Register(UserRegisterDto userRegisterDto);
    public String Login(UserLoginDto userLoginDto);
    public List<User> getUser();



}
