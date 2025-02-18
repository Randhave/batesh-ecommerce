package com.product.mapper;

import com.product.entity.Product;
import com.product.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductModel mapProductEntityToProductModel(Product product);

    Product mapProductModelToProductEntity(ProductModel productModel);

    void updateProductModel(@MappingTarget ProductModel productModel, Product product);

    List<ProductModel> mapToProductModelList(List<Product> products);
}
