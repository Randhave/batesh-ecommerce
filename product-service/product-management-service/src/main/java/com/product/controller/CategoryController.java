package com.product.controller;

import com.product.apis.CategoriesApi;
import com.product.mapper.GenericResponseMapper;
import com.product.models.CategoryModel;
import com.product.models.GenericResponse;
import com.product.service.CategoryService;
import com.product.utils.ResponseHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CategoryController implements CategoriesApi {

    private final CategoryService categoryService;
    private final GenericResponseMapper genericResponseMapper;

    @Override
    public ResponseEntity<GenericResponse> createNewCategory(CategoryModel categoryModel) {
        log.info("Creating new category with name: {}", categoryModel.getName());
        var createdCategory = categoryService.createOrUpdateCategory(categoryModel);
        log.info("Category created successfully with id: {}", createdCategory.getCategoryId());
        return ResponseHelper.returnGenericResponse(createdCategory, "Category created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCategoryById(Long id) {
        log.debug("Deleting category with id: {}", id);
        categoryService.deleteCategoryById(id.intValue());
        log.debug("Category deleted successfully with id: {}", id);
        return ResponseEntity.ok("Category deleted successfully");
    }

    @Override
    public ResponseEntity<GenericResponse> getAllCategories(Integer page, Integer size, String sortBy, String sortDirection) {
        log.info("Fetching all categories with page: {}, size: {}, sortBy: {}, sortDirection: {}", page, size, sortBy, sortDirection);
        var categories = categoryService.getAllCategories(page, size, sortBy, sortDirection);
        log.info("Fetched {} categories", categories.getContent().size());
        return ResponseHelper.returnGenericResponse(categories, "Categories fetched successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getCategoryById(Long id) {
        log.info("Fetching category with id: {}", id);
        var category = categoryService.getCategoryDetailsById(id.intValue());
        log.info("Fetched category with id: {}", id);
        return ResponseHelper.returnGenericResponse(category, "Categories fetched successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> updateCategory(Long id, CategoryModel categoryModel) {
        log.info("Updating category with id: {}", id);
        var updatedCategory = categoryService.createOrUpdateCategory(categoryModel);
        log.info("Category updated successfully with id: {}", id);
        return ResponseHelper.returnGenericResponse(updatedCategory, "Categories fetched successfully", HttpStatus.OK);
    }
}
