package com.jobseeker.logic.service;

import com.jobseeker.dto.Review;
import com.jobseeker.dto.mapper.ReviewMapper;
import com.jobseeker.persistence.EmployerRepository;
import com.jobseeker.persistence.ReviewRepository;
import com.jobseeker.persistence.UserRepository;
import com.jobseeker.persistence.entity.EmployerEntity;
import com.jobseeker.persistence.entity.ReviewEntity;
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
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployerRepository employerRepository;


    public List<Review> getAllReviews() {
        List<ReviewEntity> allReviews = reviewRepository.findAll();
        return reviewMapper.toReview(allReviews);
    }

    public List<Review> getAllUsersReviews(final long userId) {
        Optional<UserEntity> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            List<ReviewEntity> usersReviews = reviewRepository.findAllByUserEntity(userById.get());
            return reviewMapper.toReview(usersReviews);
        }
        log.info("User with id {} not found in database", userById);
        return Collections.emptyList();
    }

    public List<Review> getAllEmployersReviews(final long empId) {
        Optional<EmployerEntity> empById = employerRepository.findById(empId);
        if (empById.isPresent()) {
            List<ReviewEntity> employerReviews = reviewRepository.findAllByEmployerEntity(empById.get());
            return reviewMapper.toReview(employerReviews);
        }
        log.warn("Employer with id {} not found in database", empById);
        return Collections.emptyList();
    }

    // ===================================   POST   =====================================================


    public Review addReviewToUser(final long userId, final Review review) {
        Optional<UserEntity> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            ReviewEntity reviewEntity = reviewMapper.toEntity(review);
            reviewEntity.setUserEntity(userById.get());
            return saveReviewToDB(reviewEntity);
        }
        log.warn("User with id {} not found in database", userById);
        return null;
    }

    public Review addReviewToEmployer(final long empId, final Review review) {
        Optional<EmployerEntity> employerById = employerRepository.findById(empId);
        if (employerById.isPresent()) {
            ReviewEntity reviewEntity = reviewMapper.toEntity(review);
            reviewEntity.setEmployerEntity(employerById.get());
            return saveReviewToDB(reviewEntity);
        }
        log.warn("Employer with id {} not found in database", employerById);
        return null;
    }


    private Review saveReviewToDB(ReviewEntity reviewEntity) {
        ReviewEntity savedReview = reviewRepository.save(reviewEntity);
        return reviewMapper.toReview(savedReview);
    }

    // ======================================   DELETE   =====================================================

    public void deleteReview(final long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
