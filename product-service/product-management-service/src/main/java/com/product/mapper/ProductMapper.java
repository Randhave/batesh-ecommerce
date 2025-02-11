package com.product.mapper;

import com.product.entity.Product;
import com.product.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductMapper INSTANCE  = Mappers.getMapper(ProductMapper.class);

    ProductModel mapProductEntityToProductModel(Product product);

    Product mapProductModelToProductEntity(ProductModel productModel);

    void updateProductModel(@MappingTarget ProductModel productModel, Product product);
}
