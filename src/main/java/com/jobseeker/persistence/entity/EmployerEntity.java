package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYER")
@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue(value = UserParentEntity.EMPLOYER)
@SequenceGenerator(name = "EMPLOYER_ID_GENERATOR", sequenceName = "SEQ_EMPLOYER_ID", allocationSize = 1)
public class EmployerEntity extends UserParentEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "ABOUT")
    private String about;

}
