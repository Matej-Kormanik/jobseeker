package com.jobseeker.logic.service;

import com.jobseeker.dto.JobSeekerAuthDetailsTO;
import com.jobseeker.persistence.UserParentRepository;
import com.jobseeker.persistence.entity.UserParentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserParentRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserParentEntity> optUser = userRepository.findByUsername(username);
        optUser.orElseThrow(() -> new UsernameNotFoundException("User not found : " + username));

        return optUser
                .map(JobSeekerAuthDetailsTO::new)
                .orElse(null);
    }

}
