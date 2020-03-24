package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

}
