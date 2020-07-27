package com.jobseeker.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "USER_PARENT_ID_GENERATOR", sequenceName = "SEQ_USER_ID", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class UserParentEntity {

    public static final String EMPLOYER = "EMPLOYER";
    public static final String APP_USER = "APP_USER";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PARENT_ID_GENERATOR")
    private long id;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "EMAIL")
    private String email;

}
