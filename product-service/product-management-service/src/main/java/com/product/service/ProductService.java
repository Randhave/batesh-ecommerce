package com.product.service;

import com.product.model.ProductModel;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductModel createProduct(ProductModel product);

    ProductModel getProductById(Long id);

    Page<ProductModel> getAllProducts(Integer page, Integer size, String sortBy, String sortDirection);

    ProductModel updateProduct(Long id, ProductModel product);

    void deleteProduct(Long id);
}
