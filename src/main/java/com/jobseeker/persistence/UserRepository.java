package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
