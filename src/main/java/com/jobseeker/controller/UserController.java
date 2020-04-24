package com.jobseeker.controller;

import com.jobseeker.dto.Skill;
import com.jobseeker.dto.User;
import com.jobseeker.logic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // =================================  user's skills  ================================================

    @GetMapping(path = "users/{userId}/skills", produces = "application/json")
    public ResponseEntity<List<Skill>> getAllUsersSkills(@PathVariable long userId) {
        List<Skill> allUsersSkills = userService.getAllUsersSkills(userId);
        return new ResponseEntity<>(allUsersSkills, HttpStatus.OK);
    }

    @PostMapping(path = "users/{userId}/skills", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Skill> addNewUsersSkill(@PathVariable long userId, @RequestBody Skill skill) {
        Skill savedSkill = userService.addNewSkillForUser(userId, skill);
        return new ResponseEntity<>(savedSkill, HttpStatus.CREATED);
    }

}
