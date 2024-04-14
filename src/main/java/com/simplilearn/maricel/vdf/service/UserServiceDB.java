package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceDB extends UserDetailsService {

    public User findByUsername(String username);
}
