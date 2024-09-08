package com.rishabh.Lab.Repository;

import com.rishabh.Lab.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,String> {
   Optional<User> findByEmail(String email);
   Optional<User> findByUsername(String username);
}
