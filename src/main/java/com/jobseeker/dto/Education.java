package com.jobseeker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Education {

    private Long id;

    private String school;

    private String major;

    private String description;

    private LocalDate fromDate;

    private LocalDate toDate;

    private UserParent user;

}
