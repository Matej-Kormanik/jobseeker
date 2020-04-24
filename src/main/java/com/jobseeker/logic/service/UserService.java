package com.jobseeker.logic.service;

import com.jobseeker.dto.Skill;
import com.jobseeker.dto.User;
import com.jobseeker.dto.mapper.SkillMapper;
import com.jobseeker.dto.mapper.UserMapper;
import com.jobseeker.persistence.SkillRepository;
import com.jobseeker.persistence.UserRepository;
import com.jobseeker.persistence.entity.SkillEntity;
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
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillMapper skillMapper;


    public User createNewUser(User user) {
        return saveUserToDb(userMapper.toEntity(user));
    }

    private User saveUserToDb(UserEntity userEntity) {
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toUser(savedUser);
    }

    public User updateExistingUser(User updatedUser, long id) {
        Optional<UserEntity> foundOptUser = userRepository.findById(id);
        return foundOptUser.map(existingUserEntity -> {
            existingUserEntity.setEmail(updatedUser.getEmail());
            existingUserEntity.setFirstName(updatedUser.getFirstName());
            existingUserEntity.setLastName(updatedUser.getLastName());
            existingUserEntity.setPassword(updatedUser.getPassword());
            existingUserEntity.setUsername(updatedUser.getUsername());
            return saveUserToDb(existingUserEntity);
        }).orElseGet(null);
    }

    public boolean deletedUser(long userId) {
        Optional<UserEntity> foundUser = userRepository.findById(userId);
        foundUser.ifPresent(userRepository::delete);
        return foundUser.isPresent();
    }

    public User findUserById(long userId) {
        Optional<UserEntity> optUser = userRepository.findById(userId);
        return optUser
                .map(userMapper::toUser)
                .orElse(null);
    }

    public List<User> findAllUsers() {
        return userMapper.toUser(userRepository.findAll());
    }


    // =================================  user's skills  ================================================

    public List<Skill> getAllUsersSkills(final long userId) {
        Optional<UserEntity> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            List<SkillEntity> skillEntities = userById.get().getSkills();
            return skillMapper.toSkill(skillEntities);
        }
        return Collections.emptyList();
    }

    public Skill addNewSkillForUser(final long userId, final Skill skill) {
        Optional<UserEntity> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            SkillEntity skillEntity = skillMapper.toEntity(skill);
            skillEntity.addUserHavingSkill(userById.get());
            SkillEntity savedSkill = skillRepository.save(skillEntity);
            return skillMapper.toSkill(savedSkill);
        }
        return null;
    }

}
