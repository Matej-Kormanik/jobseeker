package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "REVIEW_ID_GENERATOR", sequenceName = "SEQ_REVIEW_ID", allocationSize = 1)
public class ReviewEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEW_ID_GENERATOR")
    private Long id;

    @Column(name = "stars")
    private int stars;

    @Column(name = "FEEDBACK")
    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EMPLOYER_ID")
    private EmployerEntity employerEntity;

}
