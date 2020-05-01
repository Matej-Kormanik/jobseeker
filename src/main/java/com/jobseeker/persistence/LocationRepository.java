package com.jobseeker.persistence;

import com.jobseeker.persistence.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    List<LocationEntity> findAllByEmployerEntityId(long employerId);

}
