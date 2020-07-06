package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.ReviewEntity;
import com.jobseeker.persistence.entity.UserParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findAllByUserParentEntity(UserParentEntity user);

}
