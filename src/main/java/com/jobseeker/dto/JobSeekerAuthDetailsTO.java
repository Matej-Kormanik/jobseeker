package com.jobseeker.dto;

import com.jobseeker.persistence.entity.EmployerEntity;
import com.jobseeker.persistence.entity.UserEntity;
import com.jobseeker.persistence.entity.UserParentEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JobSeekerAuthDetailsTO implements UserDetails {

    private final String userName;
    private final String password;
    private final boolean enabled;
    private List<GrantedAuthority> grantedAuthorities;

    public JobSeekerAuthDetailsTO(UserParentEntity userParentEntity) {
        this.userName = userParentEntity.getUsername();
        this.password = userParentEntity.getPassword();
        this.enabled = userParentEntity.isEnabled();
        setAuthority(userParentEntity);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    private void setAuthority(UserParentEntity userParentEntity) {
        if (grantedAuthorities == null) {
            this.grantedAuthorities = new ArrayList<>();
        }
        GrantedAuthority grantedAuthority = null;

        if (userParentEntity instanceof UserEntity) {
            grantedAuthority = new SimpleGrantedAuthority(Roles.ROLE_USER.getName());
        }
        if (userParentEntity instanceof EmployerEntity) {
            grantedAuthority = new SimpleGrantedAuthority(Roles.ROLE_EMPLOYER.getName());
        }
        grantedAuthorities.add(grantedAuthority);
    }
}
