package com.jobseeker.dto;

public enum Roles {

    ROLE_USER("ROLE_USER"),

    ROLE_EMPLOYER("ROLE_EMPLOYER"),

    ROLE_ADMIN("ROLE_ADMIN");



    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
