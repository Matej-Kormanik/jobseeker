package com.jobseeker.controller;

import com.jobseeker.dto.Employer;
import com.jobseeker.dto.exception.ResourceNotCreatedException;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.dto.exception.ResourceNotUpdatedException;
import com.jobseeker.logic.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
            throw new ResourceNotFoundException("Employer with id '{"+ empId + "}' not found");
        }
        return new ResponseEntity<>(employerById, HttpStatus.OK);
    }

    @PostMapping(path = "/employers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employer> createNewEmployer(@RequestBody Employer employer, UriComponentsBuilder ucb) {
        Employer savedEmployer = employerService.createNewEmployer(employer);
        if (savedEmployer == null) {
            log.error("New Employer not created");
            throw new ResourceNotCreatedException("New Employer not created");
        }
        HttpHeaders headers = setHeaders(ucb, savedEmployer);
        return new ResponseEntity<>(savedEmployer, headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "/employers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employer> updateEmployer(@RequestBody Employer employer) {
        Employer updatedEmployer = employerService.updateEmployer(employer);
        if (updatedEmployer == null) {
            log.error("Entity '{}' for update must have ID", employer);
            throw new ResourceNotUpdatedException("Entity for update must have ID");
        }
        return new ResponseEntity<>(updatedEmployer, HttpStatus.OK);
    }

    @DeleteMapping(path = "/employers/{empId}")
    public ResponseEntity<?> deleteEmployerById(@PathVariable long empId) {
        employerService.deleteEmployerById(empId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    private HttpHeaders setHeaders(UriComponentsBuilder ucb, Employer savedEmployer) {
        HttpHeaders headers = new HttpHeaders();
        URI uri = ucb
                .path("/rest/web/employers/")
                .path(String.valueOf(savedEmployer.getId()))
                .build().toUri();
        headers.setLocation(uri);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}









