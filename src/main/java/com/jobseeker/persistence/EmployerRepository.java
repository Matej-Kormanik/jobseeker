package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {

}
