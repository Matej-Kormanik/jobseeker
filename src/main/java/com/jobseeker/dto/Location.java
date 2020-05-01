package com.jobseeker.dto;

import lombok.Data;

@Data
public class Location {

    private Long id;

    private String street;

    private String houseNumber;

    private String zipCode;

    private String city;

    private String country;

    private double latitude;

    private double longitude;

    private Employer employer;


}
