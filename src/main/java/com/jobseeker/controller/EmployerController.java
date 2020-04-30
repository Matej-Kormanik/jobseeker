package com.jobseeker.controller;

import com.jobseeker.dto.Employer;
import com.jobseeker.dto.exception.ResourceNotCreatedException;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.logic.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/web")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping(path = "/employers", produces = "application/json")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> allEmployers = employerService.getAllEmployers();
        if (allEmployers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allEmployers, HttpStatus.OK);
    }

    @GetMapping(path = "/employers/{empId}", produces = "application/json")
    public ResponseEntity<Employer> getEmployerById(@PathVariable long empId) {
        Employer employerById = employerService.getEmployerById(empId);
        if (employerById == null) {
            log.warn("Employer with id '{}' not found", empId);
            throw new ResourceNotFoundException("Employer with id '{}' not found");
        }
        return new ResponseEntity<>(employerById, HttpStatus.OK);
    }

    @PostMapping(path = "/employers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employer> createNewEmployer(@RequestBody Employer employer) {
        Employer savedEmployer = employerService.createNewEmployer(employer);
        if (savedEmployer == null) {
            log.warn("New Employer not created");
            throw new ResourceNotCreatedException("New Employer not created");
        }
        return new ResponseEntity<>(savedEmployer, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/employers/{empId}")
    public ResponseEntity<?> deleteEmployerById(@PathVariable long empId) {
        employerService.deleteEmployerById(empId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}









