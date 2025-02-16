package com.product.mapper;

import com.product.entity.Review;
import com.product.models.ReviewModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {

    ReviewModel mapToReviewModel(Review review);

    Review mapToReviewEntity(ReviewModel reviewModel);

    void mapToModelToEntity(@MappingTarget Review review, ReviewModel reviewModel);
}
