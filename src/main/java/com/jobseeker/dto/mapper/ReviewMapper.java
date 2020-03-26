package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Review;
import com.jobseeker.persistence.entity.ReviewEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review toReview(ReviewEntity reviewEntity);
    List<Review> toReview(List<ReviewEntity> reviewEntities);

    ReviewEntity toEntity(Review review);
    List<ReviewEntity> toEntity(List<Review> reviews);

}
