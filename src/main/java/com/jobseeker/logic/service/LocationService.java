package com.jobseeker.logic.service;

import com.jobseeker.dto.Location;
import com.jobseeker.dto.mapper.LocationMapper;
import com.jobseeker.persistence.LocationRepository;
import com.jobseeker.persistence.entity.LocationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;


    public List<Location> getAllLocations() {
        List<LocationEntity> allLocations = locationRepository.findAll();
        return locationMapper.toLocations(allLocations);
    }

}
