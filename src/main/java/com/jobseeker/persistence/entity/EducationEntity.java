package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EDUCATION")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "EDU_ID_GENERATOR", sequenceName = "SEQ_EDUCATION_ID", allocationSize = 1)
public class EducationEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDU_ID_GENERATOR")
    private Long id;

    @Column(name = "SCHOOL")
    private String school;

    @Column(name = "major")
    private String major;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FROM_DATE", columnDefinition = "DATE")
    private LocalDate fromDate;

    @Column(name = "TO_DATE", columnDefinition = "DATE")
    private LocalDate toDate;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;



}
