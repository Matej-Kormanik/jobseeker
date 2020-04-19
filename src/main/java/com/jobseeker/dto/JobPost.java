package com.jobseeker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class JobPost {

    private Long id;

    private String title;

    private String description;

    private LocalDate createdDate;

    private JobType type;

    private Employer employer;

}
