package com.jobseeker.dto.mapper;

import com.jobseeker.dto.JobPost;
import com.jobseeker.persistence.entity.JobPostEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobPostMapper {

    JobPost toJobPost(JobPostEntity jobPostEntity);
    List<JobPost> toJobPosts(List<JobPostEntity> jobPostEntities);

    JobPostEntity toEntity(JobPost jobPost);
    List<JobPostEntity> toEntities(List<JobPost> jobPosts);
}
