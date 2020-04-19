package com.jobseeker.logic.service;

import com.jobseeker.dto.Experience;
import com.jobseeker.dto.User;
import com.jobseeker.dto.mapper.ExperienceMapper;
import com.jobseeker.dto.mapper.UserMapper;
import com.jobseeker.persistence.ExperienceRepository;
import com.jobseeker.persistence.entity.ExperienceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    public List<Experience> getAllExperiences() {
        return experienceMapper.toExperience(experienceRepository.findAll());
    }

    public Experience getExperienceById(final long experienceId) {
        Optional<ExperienceEntity> optEntity = experienceRepository.findById(experienceId);
        return optEntity
                .map(experienceMapper::toExperience)
                .orElse(null);
    }

    // =========================  user's experience ================================

    public List<Experience> getAllUsersExperiences(final long userId) {
        User user = userService.findUserById(userId);
        List<ExperienceEntity> usersExperiences = experienceRepository.findAllByUserEntity(userMapper.toEntity(user));
        return experienceMapper.toExperience(usersExperiences);
    }

    public Experience getUsersExperience(final long userId, final long experienceId) {
        List<Experience> allUsersExperiences = getAllUsersExperiences(userId);
        return allUsersExperiences
                .stream()
                .filter(experience -> experience.getId() == experienceId)
                .findFirst()
                .orElse(null);
    }
}
