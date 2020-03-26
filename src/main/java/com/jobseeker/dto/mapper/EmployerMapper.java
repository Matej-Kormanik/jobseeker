package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Employer;
import com.jobseeker.persistence.entity.EmployerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

    Employer toEmployer(EmployerEntity EmployerEntity);
    List<Employer> toEmployer(List<EmployerEntity> employerEntities);

    EmployerEntity toEntity(Employer Employer);
    List<EmployerEntity> toEntity(List<Employer> employers);

}
