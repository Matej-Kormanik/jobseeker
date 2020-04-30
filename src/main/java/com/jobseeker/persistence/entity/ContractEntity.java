package com.jobseeker.persistence.entity;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CONTRACT")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_CONTRACT_ID", allocationSize = 1)
public class ContractEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
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
