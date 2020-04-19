package com.jobseeker.controller;

import com.jobseeker.dto.Experience;
import com.jobseeker.logic.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Experience getExperienceById(@PathVariable int id) {
        return experienceService.getExperienceById(id);
    }

    // =========================  user's experience ================================

    @GetMapping(path = "/users/{userId}/experiences")
    public List<Experience> getAllUsersExperiences(@PathVariable int userId) {
        return experienceService.getAllUsersExperiences(userId);
    }

    @GetMapping(path = "/users/{userId}/experiences/{experienceId}")
    public Experience getUsersExperience(@PathVariable int userId, @PathVariable int experienceId) {
        return experienceService.getUsersExperience(userId, experienceId);
    }

}
