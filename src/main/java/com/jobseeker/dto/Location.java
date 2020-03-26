package com.jobseeker.dto;

import com.jobseeker.persistence.entity.EmployerEntity;
import lombok.Data;

@Data
public class Location {

    private Long id;

    private String street;

    private String houseNumber;

    private String zipCode;

    private String City;

    private String country;

    private double latitude;

    private double longitude;

    private Employer employer;


}
