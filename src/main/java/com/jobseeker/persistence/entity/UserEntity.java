package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "APP_USER")
@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue(value = UserParentEntity.APP_USER)
public class UserEntity extends UserParentEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "usersHavingASkill")
    private List<SkillEntity> skills;



    public void addSkill(SkillEntity skillEntity) {
        if (skills == null) {
            skills = new LinkedList<>();
        }
        skills.add(skillEntity);
    }

    public void removeSkill(SkillEntity skillEntity) {
        skills.remove(skillEntity);
    }

}
