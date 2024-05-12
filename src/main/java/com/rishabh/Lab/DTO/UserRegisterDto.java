package com.rishabh.Lab.DTO;

import com.rishabh.Lab.Entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRegisterDto {


    private String username;
    private String email;
    private String passwordHash;
    private String firstname;
    private String lastname;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Set<Course> courseUser;


}
