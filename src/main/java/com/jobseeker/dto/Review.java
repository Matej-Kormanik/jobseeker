package com.jobseeker.dto;

import com.jobseeker.dto.User;
import com.jobseeker.persistence.entity.EmployerEntity;
import com.jobseeker.persistence.entity.UserEntity;
import lombok.Data;

@Data
public class Review {

    private Long id;

    private int stars;

    private String feedback;

    private User user;

    private Employer employer;

}
