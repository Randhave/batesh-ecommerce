package com.product.service.impl;

import com.product.handler.BadRequestException;
import com.product.handler.NotFoundException;
import com.product.mapper.ReviewMapper;
import com.product.models.ReviewModel;
import com.product.repository.ReviewRepository;
import com.product.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewModel giveReview(ReviewModel reviewModel) {
        if (reviewModel.getProductId() == null) {
            throw new BadRequestException("productId is required for add review");
        }
        log.debug("giving review for productId : {}", reviewModel.getProductId());
        var newReview = reviewMapper.mapToReviewEntity(reviewModel);
        var persistedReview = reviewRepository.save(newReview);
        log.debug("review is added successfully for productId : {} ", reviewModel.getProductId());
        return reviewMapper.mapToReviewModel(persistedReview);
    }

    @Override
    public ReviewModel getReviewDetailsByReviewId(Long ratingId) {
        return reviewMapper.mapToReviewModel(
                reviewRepository.findById(ratingId).orElseThrow(() ->
                        new NotFoundException(String.format("review not found for ratingId : %d ", ratingId))));
    }

    @Override
    public List<ReviewModel> getAllReviewsByProductId(Long productId) {
        log.debug("fetching all reviews for productId : {}", productId);
        var reviewsList = reviewRepository.findAllByProductId(productId);
        return reviewsList.stream().map(reviewMapper::mapToReviewModel).toList();
    }

    @Override
    public ReviewModel updateReview(ReviewModel reviewModel) {
        var ratingId = reviewModel.getRatingId();
        var existingReview = reviewRepository.findById(ratingId).orElseThrow(() ->
                new NotFoundException(String.format("Review not found for ratingId : {}", ratingId)));
        reviewMapper.mapToModelToEntity(existingReview, reviewModel);
        var updatedReview = reviewRepository.save(existingReview);
        log.debug("review updated successfully for ratingId : {}", ratingId);
        return reviewMapper.mapToReviewModel(updatedReview);
    }

    @Override
    public void deleteReview(Long ratingId) {
        log.debug("deleting review for ratingId :{} ", ratingId);
        reviewRepository.deleteById(ratingId);
    }
}
