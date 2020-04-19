package com.jobseeker.logic.service;

import com.jobseeker.dto.User;
import com.jobseeker.dto.mapper.UserMapper;
import com.jobseeker.persistence.UserRepository;
import com.jobseeker.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public User createNewUser(User user) {
        return saveUserToDb(userMapper.toEntity(user));
    }

    private User saveUserToDb(UserEntity userEntity) {
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toUser(savedUser);
    }

    @Transactional
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

    @Transactional
    public boolean deletedUser(long userId) {
        Optional<UserEntity> foundUser = userRepository.findById(userId);
        foundUser.ifPresent(userRepository::delete);
        return foundUser.isPresent();
    }

    @Transactional(readOnly = true)
    public User findUserById(long userId) {
        Optional<UserEntity> optUser = userRepository.findById(userId);
        return optUser
                .map(userMapper::toUser)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userMapper.toUser(userRepository.findAll());
    }



}
