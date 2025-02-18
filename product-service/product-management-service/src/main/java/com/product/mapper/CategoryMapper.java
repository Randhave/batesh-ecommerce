package com.product.mapper;

import com.product.entity.Category;
import com.product.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryModel mapToCategoryModel(Category category);

    Category mapToEntity(CategoryModel categoryModel);

    void mapModelToEntity(@MappingTarget Category category,CategoryModel categoryModel);
}
