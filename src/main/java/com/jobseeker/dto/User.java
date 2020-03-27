package com.jobseeker.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;


    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, firstName, lastName);
    }
}
