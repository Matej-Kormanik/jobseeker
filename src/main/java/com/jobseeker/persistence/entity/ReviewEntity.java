package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
@Getter @Setter
@NoArgsConstructor
public class ReviewEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "stars")
    private int stars;

    @Column(name = "FEEDBACK")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID")
    private EmployerEntity employerEntity;

}
