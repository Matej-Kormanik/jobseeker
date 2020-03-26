package com.jobseeker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Contract {

    private Long id;

    private LocalDate createdDate;

    private User user;

    private JobPost jobPost;

}
