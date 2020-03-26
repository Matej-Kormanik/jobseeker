package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Education;
import com.jobseeker.persistence.entity.EducationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    Education toEducation(EducationEntity EducationEntity);
    List<Education> toEducation(List<EducationEntity> educationEntities);

    EducationEntity toEntity(Education Education);
    List<EducationEntity> toEntity(List<Education> educations);

}
