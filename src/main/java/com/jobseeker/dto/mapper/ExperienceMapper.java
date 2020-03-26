package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Experience;
import com.jobseeker.persistence.entity.ExperienceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    Experience toExperience(ExperienceEntity experienceEntity);
    List<Experience> toExperience(List<ExperienceEntity> experienceEntities);

    ExperienceEntity toEntity(Experience experience);
    List<ExperienceEntity> toEntity(List<Experience> experiences);

}
