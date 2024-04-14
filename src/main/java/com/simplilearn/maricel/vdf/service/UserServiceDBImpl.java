package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceDBImpl implements UserServiceDB{

    @Autowired
    private UserServiceImpl userService;


    @Override
    public User findByUsername(String username) {
        // check db if user exists
        return userService.getUserByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return org.springframework.security.core.userdetails.User
                .builder().username(user.getUsername()).password(user.getPassword()).roles(getRoles(user)).build();
    }

    public String[] getRoles(User user) {
        if(user.getRole()==null) {
            return new String[] {"CUSTOMER"};
        }else {
            return user.getRole().split(",");
        }
    }


}
