package com.simplilearn.maricel.vdf.api;

import com.simplilearn.maricel.vdf.exceptions.UserNotFoundException;
import com.simplilearn.maricel.vdf.model.User;
import com.simplilearn.maricel.vdf.service.UserRepository;
import com.simplilearn.maricel.vdf.service.UserService;
import com.simplilearn.maricel.vdf.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAll")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("objectList", users);
        return "customer";
    }

    @GetMapping("/getByUsername")
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUserName(username);
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public List<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/changePassword")
    public List<User> changePassword(@RequestParam int id,
                                     @RequestBody String password) throws UserNotFoundException {
        return userService.changePassword(id, password);
    }

    @PutMapping("/changeRole")
    public List<User> changeRole(@RequestParam int id,
                                 @RequestParam String role) throws UserNotFoundException {
        return userService.changeRole(id, role);
    }

    @DeleteMapping("/delete")
    public List<User> deleteUser(@RequestParam int id) throws UserNotFoundException {
        return userService.deleteUser(id);
    }
}
