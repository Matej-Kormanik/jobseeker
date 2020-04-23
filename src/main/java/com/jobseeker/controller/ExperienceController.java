package com.jobseeker.controller;

import com.jobseeker.dto.Experience;
import com.jobseeker.logic.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/web")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;


    @GetMapping(path = "/experiences", produces = "application/json")
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> allExperiences = experienceService.getAllExperiences();
        return new ResponseEntity<>(allExperiences, HttpStatus.OK);
    }

    @GetMapping(path = "/experiences/{id}", produces = "application/json")
    public ResponseEntity<Experience> getExperienceById(@PathVariable long id) {
        Experience experienceById = experienceService.getExperienceById(id);
        return new ResponseEntity<>(experienceById, HttpStatus.OK);
    }

    @PostMapping(path = "/experiences")
    public ResponseEntity<Experience> createNewExperience(@RequestBody Experience experience) {
        Experience savedExperience = experienceService.saveNewExperience(experience);
        return new ResponseEntity<>(savedExperience, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/experiences/{id}")
    public void deleteExperience(@PathVariable long id) {
        experienceService.deleteExperience(id);
    }

    // =================================  user's experience  ================================================

    @GetMapping(path = "/users/{userId}/experiences", produces = "application/json")
    public List<Experience> getAllUsersExperiences(@PathVariable int userId) {
        return experienceService.getAllUsersExperiences(userId);
    }

    @GetMapping(path = "/users/{userId}/experiences/{experienceId}", produces = "application/json")
    public Experience getUsersExperience(@PathVariable long userId, @PathVariable long experienceId) {
        return experienceService.getUsersExperience(userId, experienceId);
    }

    @PostMapping(path = "/users/{userId}/experiences", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Experience> createExperienceForUser(@PathVariable long userId, @RequestBody Experience experience) {
        Experience savedExperience = experienceService.saveExperienceForUser(userId, experience);
        return new ResponseEntity<>(savedExperience, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/users/{userId}/experiences/{experienceId}")
    public void deleteUsersExperience(@PathVariable long userId, @PathVariable long experienceId) {
        experienceService.deleteUsersExperience(userId, experienceId);
    }

}
