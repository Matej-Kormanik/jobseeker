package com.jobseeker.controller;

import com.jobseeker.dto.Experience;
import com.jobseeker.logic.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/web")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;


    @GetMapping(path = "/experiences")
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping(path = "/experiences/{id}")
    public Experience getExperienceById(@PathVariable long id) {
        return experienceService.getExperienceById(id);
    }

    @PostMapping(path = "/experiences")
    public Experience createNewExperience(@RequestBody Experience experience) {
        return experienceService.saveNewExperience(experience);
    }

    @DeleteMapping(path = "/experiences/{id}")
    public void deleteExperience(@PathVariable long id) {
        experienceService.deleteExperience(id);
    }

    // =========================  user's experience ================================

    @GetMapping(path = "/users/{userId}/experiences")
    public List<Experience> getAllUsersExperiences(@PathVariable int userId) {
        return experienceService.getAllUsersExperiences(userId);
    }

    @GetMapping(path = "/users/{userId}/experiences/{experienceId}")
    public Experience getUsersExperience(@PathVariable long userId, @PathVariable long experienceId) {
        return experienceService.getUsersExperience(userId, experienceId);
    }

    @PostMapping(path = "/users/{userId}/experiences")
    public Experience createExperienceForUser(@PathVariable long userId, @RequestBody Experience experience) {
        return experienceService.saveExperienceForUser(userId, experience);
    }

    @DeleteMapping(path = "/users/{userId}/experiences/{experienceId}")
    public void deleteUsersExperience(@PathVariable long userId, @PathVariable long experienceId) {
        experienceService.deleteUsersExperience(userId, experienceId);
    }

}
