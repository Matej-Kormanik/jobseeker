package com.jobseeker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Experience {

    private Long id;

    private String company;

    private String title;

    private String description;

    private LocalDate fromDate;

    private LocalDate toDate;

    private User user;
}
