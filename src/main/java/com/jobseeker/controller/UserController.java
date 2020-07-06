package com.jobseeker.controller;

import com.jobseeker.dto.Skill;
import com.jobseeker.dto.User;
import com.jobseeker.dto.UserParent;
import com.jobseeker.logic.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/web")
public class UserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return appUserService.findAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public UserParent getUser(@PathVariable("id") long id) {
        return appUserService.findUserById(id);
    }

    @DeleteMapping(path = "/users/{id}")
    public boolean deleteUser(@PathVariable("id") long id) {
        return appUserService.deletedUser(id);
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return appUserService.createNewUser(user);
    }

    @PutMapping(path = "users/{id}")
    public UserParent updateUser(@RequestBody UserParent user, @PathVariable("id") long userId) {
        return appUserService.updateExistingUser(user, userId);
    }

    // =================================  user's skills  ================================================

    @GetMapping(path = "users/{userId}/skills", produces = "application/json")
    public ResponseEntity<List<Skill>> getAllUsersSkills(@PathVariable long userId) {
        List<Skill> allUsersSkills = appUserService.getAllUsersSkills(userId);
        return new ResponseEntity<>(allUsersSkills, HttpStatus.OK);
    }

    @PostMapping(path = "users/{userId}/skills", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Skill> addNewUsersSkill(@PathVariable long userId, @RequestBody Skill skill) {
        Skill savedSkill = appUserService.addNewSkillForUser(userId, skill);
        return new ResponseEntity<>(savedSkill, HttpStatus.CREATED);
    }

}
