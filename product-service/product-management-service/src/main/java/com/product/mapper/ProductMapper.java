package com.product.mapper;

import com.product.models.ProductModel;
import com.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductModel mapProductEntityToProductModel(Product product);

    Product mapProductModelToProductEntity(ProductModel productModel);

    void updateProductModel(@MappingTarget ProductModel productModel, Product product);
}
