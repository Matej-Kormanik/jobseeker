package com.jobseeker.persistence.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "LOCATION")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_LOCATION_ID", allocationSize = 1)
public class LocationEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "ZIP")
    private String zipCode;

    @Column(name = "CITY")
    private String City;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "LONGITUDE")
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID")
    private EmployerEntity employerEntity;

}
