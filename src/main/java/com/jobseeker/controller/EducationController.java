package com.jobseeker.controller;

import com.jobseeker.dto.Education;
import com.jobseeker.logic.service.EducationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/web")
public class EducationController {

    @Autowired
    private EducationService educationService;


    @GetMapping(path = "/edducations", produces = "application/json")
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> allEducations = educationService.getAllEducations();
        return new ResponseEntity<>(allEducations, HttpStatus.OK);
    }

    @GetMapping(path = "/educations/{id}", produces = "application/json")
    public ResponseEntity<Education> getEducationById(@PathVariable long id) {
        Education educationById = educationService.getEducationById(id);
        return new ResponseEntity<>(educationById, HttpStatus.OK);
    }

    @PostMapping(path = "/educations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education saveEducation = educationService.saveEducation(education);
        return new ResponseEntity<>(saveEducation, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/educations/{id}")
    public ResponseEntity<?> deleteEducationById(@PathVariable long id) {
        educationService.deleteEducationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // =================================  user's education  ================================================

    @GetMapping(path = "/users/{userId}/educations", produces = "application/json")
    public ResponseEntity<List<Education>> getAllUsersEducations(@PathVariable long userId) {
        List<Education> allUsersEducation = educationService.getAllUsersEducation(userId);
        return new ResponseEntity<>(allUsersEducation, HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}/educations/{eduId}", produces = "application/json")
    public ResponseEntity<Education> getUsersEducationById(@PathVariable long userId, @PathVariable long eduId) {
        Education foundEducation = educationService.getUsersEducationById(userId, eduId);
        return new ResponseEntity<>(foundEducation, HttpStatus.OK);
    }

    @PostMapping(path = "/users/{userId}/educations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Education> createUsersEducation(@PathVariable long userId, @RequestBody Education education) {
        Education savedEducation = educationService.createUsersEducation(userId, education);
        return new ResponseEntity<>(savedEducation, HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{userId}/educations/{eduId}")
    public void deleteUsersEducationById(@PathVariable long userId, @PathVariable long eduId) {
        educationService.removeUsersEducationById(userId, eduId);
    }


}
