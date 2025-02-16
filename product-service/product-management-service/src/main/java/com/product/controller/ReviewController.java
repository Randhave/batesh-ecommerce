package com.product.controller;

import com.product.apis.ReviewsApi;
import com.product.models.ReviewModel;
import com.product.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReviewController implements ReviewsApi {

    private final ReviewService reviewService;

    @Override
    public ResponseEntity<ReviewModel> createNewReview(Long productId, ReviewModel reviewModel) {
        log.info("giving review for productId : {} ", reviewModel.getProductId());
        var givenReview = reviewService.giveReview(reviewModel);
        return new ResponseEntity<>(givenReview, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteReviewById(Long id) {
        log.info("deleting review for reviewId : {} ", id);
        reviewService.deleteReview(id);
        log.info("review deleted successfully : {} ", id);
        return null;
    }

    @Override
    public ResponseEntity<List<ReviewModel>> getAllReviewsForProduct(Long productId) {
        log.info("fetching list reviews for productId : {} ", productId);
        var productReviews = reviewService.getAllReviewsByProductId(productId);
        log.info("successfully fetch reviewList for productId {} with size : {}", productId, productReviews.size());
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReviewModel> getReviewById(Long id) {
        log.info("get review details for reviewId : {} ", id);
        var reviewDetails = reviewService.getReviewDetailsByReviewId(id);
        return new ResponseEntity<>(reviewDetails, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReviewModel> updateReview(Long id, ReviewModel reviewModel) {
        log.info("updating review for productId : {} ", reviewModel.getProductId());
        var updatedReview = reviewService.updateReview(reviewModel);
        log.info("review updated successfully for productId : {} ", reviewModel.getProductId());
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }
}
