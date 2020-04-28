package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.EmployerEntity;
import com.jobseeker.persistence.entity.ReviewEntity;
import com.jobseeker.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findAllByUserEntity(UserEntity user);

    List<ReviewEntity> findAllByEmployerEntity(EmployerEntity employer);

}
