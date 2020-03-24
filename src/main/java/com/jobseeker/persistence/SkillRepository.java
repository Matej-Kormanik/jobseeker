package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

}
