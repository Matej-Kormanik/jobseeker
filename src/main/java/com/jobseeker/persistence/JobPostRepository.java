package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPostEntity, Long> {

}
