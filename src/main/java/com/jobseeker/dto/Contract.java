package com.jobseeker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Contract {

    private Long id;

    private LocalDate createdDate;

    private UserParent user;

    private JobPost jobPost;

}
