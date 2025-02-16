package com.product.service;

import com.product.models.ReviewModel;

import java.util.List;

public interface ReviewService {

    ReviewModel giveReview(ReviewModel reviewModel);

    ReviewModel getReviewDetailsByReviewId(Long ratingId);
    List<ReviewModel> getAllReviewsByProductId(Long productId);

    ReviewModel updateReview(ReviewModel reviewModel);

    void deleteReview(Long ratingId);
}
