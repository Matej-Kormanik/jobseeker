package com.jobseeker.logic.service;

import com.jobseeker.dto.Employer;
import com.jobseeker.dto.mapper.EmployerMapper;
import com.jobseeker.persistence.EmployerRepository;
import com.jobseeker.persistence.entity.EmployerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private EmployerMapper employerMapper;

    public List<Employer> getAllEmployers() {
        List<EmployerEntity> allEmployers = employerRepository.findAll();
        return employerMapper.toEmployer(allEmployers);
    }

    public Employer getEmployerById(final long employerId) {
        Optional<EmployerEntity> optEmployer = employerRepository.findById(employerId);
        return optEmployer
                .map(employerMapper::toEmployer)
                .orElse(null);
    }

    public Employer createNewEmployer(final Employer employer) {
        return saveToDB(employerMapper.toEntity(employer));
    }

    public void deleteEmployerById(final long employerId) {
        employerRepository.deleteById(employerId);
    }

    public Employer saveToDB(EmployerEntity employerEntity) {
        if (employerEntity == null) {
            return null;
        }
        EmployerEntity savedEmployer = employerRepository.save(employerEntity);
        return employerMapper.toEmployer(savedEmployer);
    }

}
