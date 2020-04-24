package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "APP_USER")
@Getter @Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

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
