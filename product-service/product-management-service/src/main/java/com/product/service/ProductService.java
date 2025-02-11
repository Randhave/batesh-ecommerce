package com.product.service;

import com.product.models.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel createProduct(ProductModel product);

    ProductModel getProductById(Long id);

    List<ProductModel> getAllProducts();

    ProductModel updateProduct(Long id, ProductModel product);

    void deleteProduct(Long id);
}
