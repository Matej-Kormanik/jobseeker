package com.jobseeker.dto;

import lombok.Data;

@Data
public class Review {

    private Long id;

    private int stars;

    private String feedback;

    private UserParent user;

}
