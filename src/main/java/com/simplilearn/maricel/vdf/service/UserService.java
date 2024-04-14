package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.exceptions.UserNotFoundException;
import com.simplilearn.maricel.vdf.model.User;

import java.util.List;

public interface UserService {
        List<User> getAllUsers();
        User getUserById(int id) throws UserNotFoundException;
        List<User> addUser(User user);
        List<User> changePassword(int id, String password) throws UserNotFoundException;
        List<User> changeRole(int id, String role) throws UserNotFoundException;
        List<User> deleteUser(int id) throws UserNotFoundException;
        User getUserByUserName(String username);
}
