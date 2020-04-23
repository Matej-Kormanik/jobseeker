package com.jobseeker.logic.service;

import com.jobseeker.dto.Education;
import com.jobseeker.dto.mapper.EducationMapper;
import com.jobseeker.dto.mapper.UserMapper;
import com.jobseeker.persistence.EducationRepository;
import com.jobseeker.persistence.UserRepository;
import com.jobseeker.persistence.entity.EducationEntity;
import com.jobseeker.persistence.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public List<Education> getAllEducations() {
        List<EducationEntity> allEducations = educationRepository.findAll();
        return educationMapper.toEducation(allEducations);
    }

    public Education getEducationById(final long id) {
        Optional<EducationEntity> optionalEducationEntity = educationRepository.findById(id);
        return optionalEducationEntity
                .map(educationMapper::toEducation)
                .orElse(null);
    }

    public Education saveEducation(Education education) {
        return saveEducationToDB(educationMapper.toEntity(education));
    }

    public void deleteEducationById(final long id) {
        educationRepository.deleteById(id);
    }

    // =================================  user's education  ================================================


    public List<Education> getAllUsersEducation(final long userId) {
        Optional<UserEntity> optUserEntity = userRepository.findById(userId);
        if (optUserEntity.isPresent()) {
            List<EducationEntity> allUsersEducation = educationRepository.findAllByUserEntity(optUserEntity.get());
            return educationMapper.toEducation(allUsersEducation);
        }
        return Collections.emptyList();
    }


    public Education getUsersEducationById(final long userId, final long eduId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isPresent()) {
            Optional<EducationEntity> educationEntity = educationRepository.findByUserEntityAndId(userEntity.get(), eduId);
            return educationEntity
                    .map(educationMapper::toEducation)
                    .orElse(null);
        }
        return null;
    }

    public Education createUsersEducation(final long userId, Education education) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        EducationEntity educationEntity = educationMapper.toEntity(education);
        educationEntity.setUserEntity(userEntity.get());
        return saveEducationToDB(educationEntity);
    }

    public void removeUsersEducationById(final long userId, final long eduId) {
        educationRepository.removeByUserEntityIdAndId(userId, eduId);
    }

    // =================================  helpers methods  ==================================================

    private Education saveEducationToDB(EducationEntity educationEntity) {
        EducationEntity savedEntity = educationRepository.save(educationEntity);
        return educationMapper.toEducation(savedEntity);
    }

}
