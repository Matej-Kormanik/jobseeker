package com.jobseeker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    private Long id;

    private String skill;

    private String description;

    private int seniority;

    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill1 = (Skill) o;
        return seniority == skill1.seniority &&
                Objects.equals(id, skill1.id) &&
                Objects.equals(skill, skill1.skill) &&
                Objects.equals(description, skill1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, description, seniority);
    }

}
