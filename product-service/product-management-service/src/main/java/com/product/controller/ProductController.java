package com.product.controller;

import com.product.apis.ProductsApi;
import com.product.models.ProductModel;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-api/v1/")
@Slf4j
@RequiredArgsConstructor
public class ProductController implements ProductsApi {
    private final ProductService productService;


    @Override
    public ResponseEntity<ProductModel> createNewProduct(ProductModel productModel) {
        log.info("Creating new product with id: {}, name: {}, description: {}", productModel.getProductId(), productModel.getName(), productModel.getDescription());
        var product = productService.createProduct(productModel);
        log.info("Product created successfully with id: {}", product.getProductId());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        log.info("Deleting product with id: {}", id);
        productService.deleteProduct(id);
        log.info("Product deleted successfully with id: {}", id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        log.info("Fetching all products");
        var products = productService.getAllProducts();
        log.info("Fetched {} products", products.size());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductModel> getProductById(Long id) {
        log.info("Fetching product with id: {}", id);
        var product = productService.getProductById(id);
        if (product != null) {
            log.info("Product found with id: {}", id);
        } else {
            log.info("Product not found with id: {}", id);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductModel> updateProduct(Long id, ProductModel productModel) {
        log.info("Updating product with id: {}, name: {}, description: {}", id, productModel.getName(), productModel.getDescription());
        ProductModel updatedProduct = productService.updateProduct(id, productModel);
        log.info("Product updated successfully with id: {}", id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
