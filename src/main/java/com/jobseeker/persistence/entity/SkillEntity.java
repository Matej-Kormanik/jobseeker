package com.jobseeker.persistence.entity;

import com.jobseeker.dto.SkillSeniority;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "SKILL_SENIORITY")
    private SkillSeniority seniority;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;


}
