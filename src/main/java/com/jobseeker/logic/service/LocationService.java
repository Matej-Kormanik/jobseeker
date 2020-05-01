package com.jobseeker.logic.service;

import com.jobseeker.dto.Employer;
import com.jobseeker.dto.Location;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.dto.mapper.EmployerMapper;
import com.jobseeker.dto.mapper.LocationMapper;
import com.jobseeker.persistence.LocationRepository;
import com.jobseeker.persistence.entity.LocationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private EmployerMapper employerMapper;


    public List<Location> getAllLocations() {
        List<LocationEntity> allLocations = locationRepository.findAll();
        return locationMapper.toLocations(allLocations);
    }

    public Location getLocationById(final long locationId) {
        Optional<LocationEntity> optLocation = locationRepository.findById(locationId);
        return optLocation
                .map(locationMapper::toLocation)
                .orElse(null);
    }

    public Location createNewLocation(Location location) {
        assert location.getId() == null;
        LocationEntity savedLocation = locationRepository.save(locationMapper.toEntity(location));
        return locationMapper.toLocation(savedLocation);
    }

    public void deleteLocationById(final long locationId) {
        locationRepository.deleteById(locationId);
    }

    // =================================  employer's location  ================================================

    public List<Location> getAllEmployersLocations(final long employerId) {
        List<LocationEntity> allEmpLocations = locationRepository.findAllByEmployerEntityId(employerId);
        return locationMapper.toLocations(allEmpLocations);
    }

    public Location getEmployersLocationById(final long empId, final long locationId) {
        return getAllEmployersLocations(empId).stream()
                .filter(location -> location.getId() == locationId)
                .findFirst()
                .orElse(null);
    }

    public Location createEmployerLocation(final long empId, final Location location) {
        assert location.getId() == null;
        Employer employerById = employerService.getEmployerById(empId);
        if (employerById == null) {
            throw new ResourceNotFoundException("Employer with id " + empId + " not found");
        }
        LocationEntity locationEntity = locationMapper.toEntity(location);
        locationEntity.setEmployerEntity(employerMapper.toEntity(employerById));
        return locationMapper.toLocation(locationRepository.save(locationEntity));
    }

}
