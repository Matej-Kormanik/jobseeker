package com.jobseeker.logic.service;

import com.jobseeker.dto.JobPost;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.dto.mapper.JobPostMapper;
import com.jobseeker.persistence.EmployerRepository;
import com.jobseeker.persistence.JobPostRepository;
import com.jobseeker.persistence.entity.EmployerEntity;
import com.jobseeker.persistence.entity.JobPostEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private JobPostMapper jobPostMapper;

    @Autowired
    private EmployerRepository employerRepository;

    public List<JobPost> getAllJobs() {
        List<JobPostEntity> allJobs = jobPostRepository.findAll();
        return jobPostMapper.toJobPosts(allJobs);
    }

    public JobPost getJobPostById(final long jobId) {
        Optional<JobPostEntity> jobById = jobPostRepository.findById(jobId);
        return jobById
                .map(jobPostMapper::toJobPost)
                .orElse(null);
    }

    public JobPost CreateNewJobPost(JobPost jobPost) {
        assert jobPost.getId() == null;
        return saveJobPostToDB(jobPostMapper.toEntity(jobPost));
    }

    private JobPost saveJobPostToDB(JobPostEntity jobPostEntity) {
        JobPostEntity savedJob = jobPostRepository.save(jobPostEntity);
        return jobPostMapper.toJobPost(savedJob);
    }

    public void deleteJobById(final long jobId) {
        jobPostRepository.deleteById(jobId);
    }

    // =================================  employer's job posts  ================================================

    public List<JobPost> getAllEmployerJobPosts(final long empId) {
        List<JobPostEntity> allByEmployerJobPosts = jobPostRepository.findAllByEmployerEntityId(empId);
        return jobPostMapper.toJobPosts(allByEmployerJobPosts);
    }

    public Optional<JobPost> getEmployerJobPostById(final long empId, final long jobId) {
        return getAllEmployerJobPosts(empId)
                .stream()
                .filter(jobPost -> jobPost.getId() == jobId)
                .findFirst();
    }

    public JobPost createEmployerJobPost(final long employerId, final JobPost jobPost) {
        Optional<EmployerEntity> employerEntity = employerRepository.findById(employerId);
        if (!employerEntity.isPresent()) {
            log.error("Employer with id {} not found.", employerId);
            throw new ResourceNotFoundException("Employer by id not found");
        }
        JobPostEntity jobPostEntity = jobPostMapper.toEntity(jobPost);
        jobPostEntity.setEmployerEntity(employerEntity.get());
        return saveJobPostToDB(jobPostEntity);
    }




}
