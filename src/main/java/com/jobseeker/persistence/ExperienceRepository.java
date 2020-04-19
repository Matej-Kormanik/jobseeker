package com.jobseeker.persistence;

import com.jobseeker.dto.Experience;
import com.jobseeker.persistence.entity.ExperienceEntity;
import com.jobseeker.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findAllByUserEntity(UserEntity userEntity);

}
