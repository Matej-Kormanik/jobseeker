package com.jobseeker.controller;

import com.jobseeker.dto.Review;
import com.jobseeker.logic.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/web")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // ===================================   GET   =====================================================

    @GetMapping(path = "/reviews", produces = "application/json")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> allReviews = reviewService.getAllReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}/reviews", produces = "application/json")
    public ResponseEntity<List<Review>> getAllUsersReviews(@PathVariable long userId) {
        List<Review> allUsersReviews = reviewService.getAllUsersReviews(userId);
        if (allUsersReviews.size() > 0) {
            return new ResponseEntity<>(allUsersReviews, HttpStatus.OK);
        }
        return new ResponseEntity<>(allUsersReviews, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/employers/{empId}/reviews", produces = "application/json")
    public ResponseEntity<List<Review>> getAllEmployersReviews(@PathVariable long empId) {
        List<Review> allEmployersReviews = reviewService.getAllEmployersReviews(empId);
        if (allEmployersReviews.size() > 0) {
            return new ResponseEntity<>(allEmployersReviews, HttpStatus.OK);
        }
        return new ResponseEntity<>(allEmployersReviews, HttpStatus.NO_CONTENT);
    }

    // ===================================   POST   =====================================================

    @PostMapping(path = "/users/{userId}/reviews", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Review> reviewForUser(@PathVariable long userId,  @RequestBody Review review) {
        Review savedReview = reviewService.addReviewToUser(userId, review);
        if (savedReview != null) {
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/employers/{empId}/reviews", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Review> reviewForEmployer(@PathVariable long empId,  @RequestBody Review review) {
        Review savedReview = reviewService.addReviewToEmployer(empId, review);
        if (savedReview != null) {
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    // ======================================   DELETE   =====================================================

    @DeleteMapping(path = "/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
