package com.jobseeker.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Employer extends UserParent {

    private String name;

    private String about;

}
