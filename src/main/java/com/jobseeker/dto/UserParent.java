package com.jobseeker.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class UserParent implements Serializable {

    private Long id;

    private String username;

    private String password;

    private boolean enabled;

    private String email;

    public UserParent(Long id, String username, String password, String email, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    public UserParent() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserParent that = (UserParent) o;
        return enabled == that.enabled &&
                Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, enabled);
    }
}
