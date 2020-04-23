package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.EducationEntity;
import com.jobseeker.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<EducationEntity, Long> {

    List<EducationEntity> findAllByUserEntity(UserEntity userEntity);

    Optional<EducationEntity> findByUserEntityAndId(UserEntity userEntity, long id);

    void removeByUserEntityIdAndId(long userEntityId, long id);

}
