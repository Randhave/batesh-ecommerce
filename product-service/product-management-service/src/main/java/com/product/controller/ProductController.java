package com.product.controller;

import com.product.apis.ProductsApi;
import com.product.mapper.GenericResponseMapper;
import com.product.models.GenericResponse;
import com.product.models.ProductModel;
import com.product.service.ProductService;
import com.product.utils.ResponseHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.product.utils.Constants.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private final ProductService productService;
    private final GenericResponseMapper genericResponseMapper;

    @Override
    public ResponseEntity<GenericResponse> createNewProduct(ProductModel productModel) {
        log.info("Creating new product with id: {}, name: {}, description: {}", productModel.getProductId(), productModel.getName(), productModel.getDescription());
        var product = productService.createProduct(productModel);
        log.info("Product created successfully with id: {}", product.getProductId());
        return ResponseHelper.returnGenericResponse(product, PRODUCT_CREATED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        log.info("Deleting product with id: {}", id);
        productService.deleteProduct(id);
        log.info("Product deleted successfully with id: {}", id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<GenericResponse> getAllProducts(Integer page, Integer size, String sortBy, String sortDirection) {
        log.info("Fetching all products");
        var products = productService.getAllProducts(page, size, sortBy, sortDirection);
        log.info("Fetched {} products", products);
        return ResponseHelper.returnGenericResponse(products, PRODUCT_FETCHED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getProductById(Long id) {
        log.info("Fetching product with id: {}", id);
        var product = productService.getProductById(id);
        if (product != null) {
            log.info("Product found with id: {}", id);
        } else {
            log.info("Product not found with id: {}", id);
        }
        return ResponseHelper.returnGenericResponse(product, PRODUCT_FETCHED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> updateProduct(Long id, ProductModel productModel) {
        log.info("Updating product with id: {}, name: {}, description: {}", id, productModel.getName(), productModel.getDescription());
        var updatedProduct = productService.updateProduct(id, productModel);
        log.info("Product updated successfully with id: {}", id);
        return ResponseHelper.returnGenericResponse(updatedProduct, PRODUCT_UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }
}
