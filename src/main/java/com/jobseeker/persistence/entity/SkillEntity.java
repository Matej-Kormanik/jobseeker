package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;

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

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SKILL_SENIORITY")
    private int seniority;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;


}
