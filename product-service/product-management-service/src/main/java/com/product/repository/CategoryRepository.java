package com.product.repository;

import com.product.entity.Category;
import com.product.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(""" 
                SELECT new com.product.model.CategoryModel( 
                    c.categoryId as categoryId,  
                    c.name as name,  
                    c.description as description
                )  
                FROM Category c 
            """)
    Page<CategoryModel> getAllCategories(Pageable pageable);

}
