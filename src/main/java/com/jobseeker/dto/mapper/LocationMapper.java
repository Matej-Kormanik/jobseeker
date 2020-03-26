package com.jobseeker.dto.mapper;

import com.jobseeker.dto.User;
import com.jobseeker.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    User toUser(UserEntity userEntity);
    List<User> toUser(List<UserEntity> userEntities);

    UserEntity toEntity(User user);
    List<UserEntity> toEntity(List<User> users);
}
