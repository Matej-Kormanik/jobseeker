package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {


    Optional<EmployerEntity> findByEmail(String email);

}
