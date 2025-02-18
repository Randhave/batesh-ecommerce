package com.product.service.impl;

import com.product.handler.BadRequestException;
import com.product.mapper.GenericResponseMapper;
import com.product.mapper.ProductMapper;
import com.product.models.ProductModel;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.product.utils.ResponseHelper.getSort;
import static com.product.utils.ResponseHelper.mapToPageResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final GenericResponseMapper genericResponseMapper;

    @Override
    public ProductModel createProduct(ProductModel product) {
        log.info("Creating new product with name: {}", product.getName());
        var newproduct = productRepository.save(productMapper.mapProductModelToProductEntity(product));
        var createdProduct = productMapper.mapProductEntityToProductModel(newproduct);
        log.info("Product created successfully with ID: {}", createdProduct.getProductId());
        return createdProduct;
    }

    @Override
    public ProductModel getProductById(Long id) {
        log.info("Getting product by ID: {}", id);
        var product = productRepository.findById(id).orElseThrow(() -> new BadRequestException(String.format("Product not found with ID: %d", id)));
        var productModel = productMapper.mapProductEntityToProductModel(product);
        log.info("Product found with ID: {}", id);
        return productModel;
    }

    @Override
    public Page<ProductModel> getAllProducts(Integer page, Integer size, String sortBy, String sortDirection) {
        log.info("Getting all products");
        var pageable = PageRequest.of(page, size, getSort(sortBy, sortDirection));
        var products = productRepository.findAll(pageable);
        log.info("Found {} products", products.getContent().size());
        return mapToPageResponse(products, productMapper::mapProductEntityToProductModel);
    }
    @Override
    public ProductModel updateProduct(Long id, ProductModel productModel) {
        log.info("Updating product with ID: {}", id);
        var existingProduct = getProductById(id);
        var updatedProduct = productMapper.mapProductModelToProductEntity(existingProduct);
        return productMapper.mapProductEntityToProductModel(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product with ID: {}", id);
        productRepository.deleteById(id);
        log.info("Product deleted successfully with ID: {}", id);
    }
}
