package com.product_management_service.controller;

import com.example.Product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-api/v1/")
public class ProductController  implements com.example.Product.api.ProductApi {
    @Override
    public ResponseEntity<ProductDTO> createNewProduct(ProductDTO ProductDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO ProductDTO) {
        return null;
    }
}
