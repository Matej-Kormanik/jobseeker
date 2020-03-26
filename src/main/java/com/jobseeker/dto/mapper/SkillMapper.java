package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Skill;
import com.jobseeker.persistence.entity.SkillEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    Skill toSkill(SkillEntity skillEntity);
    List<Skill> toSkill(List<SkillEntity> skillEntities);

    SkillEntity toEntity(Skill skill);
    List<SkillEntity> toEntity(List<Skill> skills);
}
