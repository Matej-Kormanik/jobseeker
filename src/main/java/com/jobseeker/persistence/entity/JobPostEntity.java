package com.jobseeker.persistence.entity;

import com.jobseeker.dto.JobType;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "JOB_POST")
@Getter @Setter
@NoArgsConstructor
public class JobPostEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private JobType type;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID")
    private EmployerEntity employerEntity;

}
