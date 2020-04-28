package com.jobseeker.persistence.entity;

import com.jobseeker.dto.SkillSeniority;
import lombok.*;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "SKILL")
@Getter @Setter
@NoArgsConstructor
public class SkillEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "SKILL_NAME", nullable = false)
    private String skill;

    @Enumerated(EnumType.STRING)
    @Column(name = "SKILL_SENIORITY")
    private SkillSeniority seniority;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "SKILL_USER_JOIN",
            joinColumns = @JoinColumn(name = "SKILL_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private List<UserEntity> usersHavingASkill;




    public void addUserHavingSkill(UserEntity user) {
        if (usersHavingASkill == null) {
            usersHavingASkill = new LinkedList<>();
        }
        usersHavingASkill.add(user);
    }

    public void removeUserHavingASkill(UserEntity userEntity) {
        usersHavingASkill.remove(userEntity);
    }

}
