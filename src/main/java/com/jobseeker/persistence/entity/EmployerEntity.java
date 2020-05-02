package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYER")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "EMPLOYER_ID_GENERATOR", sequenceName = "SEQ_EMPLOYER_ID", allocationSize = 1)
public class EmployerEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYER_ID_GENERATOR")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

}
