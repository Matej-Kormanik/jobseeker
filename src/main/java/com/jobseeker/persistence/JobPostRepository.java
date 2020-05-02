package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPostEntity, Long> {

    List<JobPostEntity> findAllByEmployerEntityId(long empId);

}
