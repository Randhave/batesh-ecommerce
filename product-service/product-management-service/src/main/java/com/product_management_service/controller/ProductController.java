package com.product_management_service.controller;

import com.product.apis.ProductsApi;
import com.product.models.ProductModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-api/v1/")
public class ProductController implements ProductsApi {
    @Override
    public ResponseEntity<ProductModel> createNewProduct(ProductModel productModel) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<ProductModel> getProductById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductModel> updateProduct(Long id, ProductModel productModel) {
        return null;
    }
}
