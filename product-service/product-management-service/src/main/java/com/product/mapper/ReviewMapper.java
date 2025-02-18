package com.product.mapper;

import com.product.entity.Review;
import com.product.model.ReviewModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewModel mapToReviewModel(Review review);

    Review mapToReviewEntity(ReviewModel reviewModel);

    void mapToModelToEntity(@MappingTarget Review review, ReviewModel reviewModel);
}
