package com.jobseeker.controller;

import com.jobseeker.dto.Location;
import com.jobseeker.logic.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
