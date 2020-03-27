package com.jobseeker.controller;

import com.jobseeker.dto.User;
import com.jobseeker.logic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/web")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping(path = "/users/{id}")
    public boolean deleteUser(@PathVariable("id") long id) {
        return userService.deletedUser(id);
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @PutMapping(path = "users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId) {
        return userService.updateExistingUser(user, userId);
    }
}
