package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.UserParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserParentRepository extends JpaRepository<UserParentEntity, Long> {

    Optional<UserParentEntity> findByUsername(String username);

}
