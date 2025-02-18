package com.product.service;

import com.product.models.CategoryModel;
import org.springframework.data.domain.Page;


public interface CategoryService {

    CategoryModel createOrUpdateCategory(CategoryModel categoryModel);

    Page<CategoryModel> getAllCategories(Integer page, Integer size, String sortBy, String sortDirection);

    void deleteCategoryById(Integer categoryId);

    CategoryModel getCategoryDetailsById(Integer categoryId);
}
