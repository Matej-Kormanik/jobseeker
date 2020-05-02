package com.jobseeker.controller;

import com.jobseeker.dto.JobPost;
import com.jobseeker.dto.exception.ResourceNotCreatedException;
import com.jobseeker.dto.exception.ResourceNotFoundException;
import com.jobseeker.logic.service.JobPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/rest/web")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;


    @GetMapping(path = "/jobs", produces = "application/json")
    public ResponseEntity<List<JobPost>> getAllJobs() {
        List<JobPost> allJobs = jobPostService.getAllJobs();
        if (allJobs.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allJobs, HttpStatus.OK);
    }


    @GetMapping(path = "/jobs/{jobId}", produces = "application/json")
    public ResponseEntity<JobPost> getJobById(@PathVariable long jobId) {
        JobPost jobPostById = jobPostService.getJobPostById(jobId);
        if (jobPostById == null) {
            log.error("Job post with id '{}' not found", jobId);
            throw new ResourceNotFoundException("Job post with id " + jobId + " not found");
        }
        return new ResponseEntity<>(jobPostById, HttpStatus.OK);
    }

    @PostMapping(path = "/jobs", consumes = "application/json", produces = "application/json")
    public ResponseEntity<JobPost> createNewJobPost(@RequestBody JobPost jobPost) {
        JobPost savedJob = jobPostService.CreateNewJobPost(jobPost);
        if (savedJob == null) {
            log.error("Job post not created.");
            throw new ResourceNotCreatedException("Job post not created.");
        }
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/jobs/{jobId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResponseById(@PathVariable long jobId) {
        jobPostService.deleteJobById(jobId);
    }

    // =================================  employer's job posts  ================================================

    @GetMapping(path = "employers/{empId}/jobs", produces = "application/json")
    public ResponseEntity<List<JobPost>> getAllEmployerJobs(@PathVariable long empId) {
        List<JobPost> allEmployerJobPosts = jobPostService.getAllEmployerJobPosts(empId);
        if (allEmployerJobPosts.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allEmployerJobPosts, HttpStatus.OK);
    }

    @GetMapping(path = "employers/{empId}/jobs/{jobId}", produces = "application/json")
    public ResponseEntity<JobPost> getEmployerJobPostById(@PathVariable long empId, @PathVariable long jobId) {
        Optional<JobPost> employerJobPostById = jobPostService.getEmployerJobPostById(empId, jobId);
        if (! employerJobPostById.isPresent()) {
            log.error("Employer with id '{}' has no job with id '{}'.", empId, jobId);
            throw new ResourceNotFoundException("Employer job post with id " +jobId + " not found.");
        }
        return new ResponseEntity<>(employerJobPostById.get(), HttpStatus.OK);
    }

    @PostMapping(path = "employers/{empId}/jobs", consumes = "application/json", produces = "application/json")
    public ResponseEntity<JobPost> createEmployerJobPost(@PathVariable long empId, @RequestBody JobPost jobPost) {
        JobPost savedJobPost = jobPostService.createEmployerJobPost(empId, jobPost);
        if (savedJobPost == null) {
            log.error("Job post not created.");
            throw new ResourceNotCreatedException("JobPost for employer id " + empId + " not found");
        }
        return new ResponseEntity<>(savedJobPost, HttpStatus.CREATED);
    }

}
