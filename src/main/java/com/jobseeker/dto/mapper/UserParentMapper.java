package com.jobseeker.dto.mapper;

import com.jobseeker.dto.UserParent;
import com.jobseeker.persistence.entity.UserParentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserParentMapper {

    UserParent toUserParent(UserParentEntity userParentEntity);
    List<UserParent> toUserParent(List<UserParentEntity> userParentEntities);

    UserParentEntity toEntity(UserParent userParent);
    List<UserParentEntity> toEntity(List<UserParent> userParentList);

}
