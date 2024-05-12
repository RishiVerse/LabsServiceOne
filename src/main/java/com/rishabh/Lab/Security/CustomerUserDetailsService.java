package com.rishabh.Lab.Security;


import com.rishabh.Lab.Entity.User;
import com.rishabh.Lab.Repository.UserDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;



@Service
@AllArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {



    private UserDetailRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User register=userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("username not found"));




        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(
                register.getEmail(),
                register.getPasswordHash(),
                authorities
        );
    }
}
