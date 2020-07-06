package com.jobseeker.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AppUser extends UserParent {

    private String firstName;

    private String lastName;

}
