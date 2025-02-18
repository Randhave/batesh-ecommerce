package com.product.service.impl;

import com.product.handler.NotFoundException;
import com.product.mapper.CategoryMapper;
import com.product.models.CategoryModel;
import com.product.repository.CategoryRepository;
import com.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryModel createOrUpdateCategory(CategoryModel categoryModel) {
        log.debug("Creating or updating category with id: {}", categoryModel.getCategoryId());
        var entity = categoryMapper.mapToEntity(categoryModel);
        if (entity.getCategoryId() == null) {
            log.debug("Creating new category ");
            entity = categoryRepository.save(entity);
            log.debug("new category created with categoryId : {} ", entity.getCategoryId());
        } else {
            categoryMapper.mapModelToEntity(entity, categoryModel);
            categoryRepository.save(entity);
            log.debug("category updated for categoryId : {} ", entity.getCategoryId());
        }
        return categoryMapper.mapToCategoryModel(entity);
    }

    @Override
    public Page<CategoryModel> getAllCategories(Integer page, Integer size, String sortBy, String sortDirection) {
        log.debug("Fetching all categories with page: {}, size: {}, sortBy: {}, sortDirection: {}", page, size, sortBy, sortDirection);
        var sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        var pageable = PageRequest.of(page, size, sort);
        var categories = categoryRepository.getAllCategories(pageable);
        log.debug("Fetched {} categories", categories.getContent().size());
        return categories;
    }

    @Override
    public void deleteCategoryById(Integer categoryId) {
        log.debug("Deleting category with id: {}", categoryId);
        categoryRepository.deleteById(categoryId);
        log.debug("Category deleted successfully with id: {}", categoryId);
    }

    @Override
    public CategoryModel getCategoryDetailsById(Integer categoryId) {
        return categoryMapper.mapToCategoryModel(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException(String.format("Category not found for categoryId  : %d", categoryId))));
    }
}
