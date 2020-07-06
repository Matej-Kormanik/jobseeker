package com.jobseeker.dto;

import java.util.LinkedList;
import java.util.List;

public class User extends UserParent {

    private String firstName;

    private String lastName;

    private List<Skill> skills;



    public void addSkill(Skill skill) {
        if (skills == null) {
            skills = new LinkedList<>();
        }
        skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }
}
