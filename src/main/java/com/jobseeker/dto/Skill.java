package com.jobseeker.dto;

import com.jobseeker.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    private Long id;

    private String skill;

    private SkillSeniority seniority;


    public Skill(String skill, SkillSeniority seniority) {
        this.skill = skill;
        this.seniority = seniority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill1 = (Skill) o;
        return seniority == skill1.seniority &&
                Objects.equals(id, skill1.id) &&
                Objects.equals(skill, skill1.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, seniority);
    }

}
