package com.jobseeker.controller;

import com.jobseeker.dto.Location;
import com.jobseeker.dto.exception.ResourceNotCreatedException;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.logic.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/web")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/locations", produces = "application/json")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> allLocations = locationService.getAllLocations();
        if (allLocations.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allLocations, HttpStatus.OK);
    }

    @GetMapping(path = "/locations/{locationId}", produces = "application/json")
    public ResponseEntity<Location> getLocationById(@PathVariable long locationId) {
        Location locationById = locationService.getLocationById(locationId);
        if (locationById == null) {
            log.warn("Location with ID '{}' has not been found", locationId);
            throw new ResourceNotFoundException("Location with ID " + locationId + " not found.");
        }
        return new ResponseEntity<>(locationById, HttpStatus.OK);
    }

    @PostMapping(path = "/locations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Location> createNewLocation(@RequestBody Location location) {
        Location savedLocation = locationService.createNewLocation(location);
        if (savedLocation == null) {
            log.error("Location was not saved");
            throw new ResourceNotCreatedException("Location not saved");
        }
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/locations/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocationById(@PathVariable long locationId) {
        locationService.deleteLocationById(locationId);
    }

    // =================================  employer's location  ================================================

    @GetMapping(path = "/employers/{empId}/locations", produces = "application/json")
    public ResponseEntity<List<Location>> getAllEmployersLocations(@PathVariable long empId) {
        List<Location> allEmployersLocations = locationService.getAllEmployersLocations(empId);
        if (allEmployersLocations.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allEmployersLocations, HttpStatus.OK);
    }

    @GetMapping(path = "/employers/{empId}/locations/{locationId}", produces = "application/json")
    public ResponseEntity<Location> getEmployerLocationById(@PathVariable long empId, @PathVariable long locationId) {
        Location employersLocationById = locationService.getEmployersLocationById(empId, locationId);
        if (employersLocationById == null) {
            throw new ResourceNotFoundException("Location with id '" + locationId + "' not found");
        }
        return new ResponseEntity<>(employersLocationById, HttpStatus.OK);
    }

    @PostMapping(path = "/employers/{empId}/locations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Location> createEmployerLocation(@PathVariable long empId, @RequestBody Location location) {
        Location employerLocation = locationService.createEmployerLocation(empId, location);
        if (employerLocation == null) {
            log.error("Location was not saved");
            throw new ResourceNotCreatedException("Location for employer id " + empId + " was not created");
        }
        return new ResponseEntity<>(employerLocation, HttpStatus.CREATED);
    }

}
