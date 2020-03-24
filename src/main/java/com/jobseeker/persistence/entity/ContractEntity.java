package com.jobseeker.persistence.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CONTRACT")
@Getter @Setter
@NoArgsConstructor
public class ContractEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "JOB_POST_ID")
    private JobPostEntity jobPostEntity;

}
