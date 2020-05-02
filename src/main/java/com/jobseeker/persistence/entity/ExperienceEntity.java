package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EXPERIENCE")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "EXPERIENCE_ID_GENERATOR", sequenceName = "SEQ_EXPERIENCE_ID", allocationSize = 1)
public class ExperienceEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPERIENCE_ID_GENERATOR")
    private Long id;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FROM_DATE", columnDefinition = "DATE")
    private LocalDate fromDate;

    @Column(name = "TO_DATE", columnDefinition = "DATE")
    private LocalDate toDate;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;

}
