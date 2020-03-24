package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<EducationEntity, Long> {

}
