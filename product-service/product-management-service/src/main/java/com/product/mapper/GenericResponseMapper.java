package com.product.mapper;

import com.product.model.GenericResponse;
import com.product.model.GenericResponseMeta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenericResponseMapper {

    @Mappings({
            @Mapping(target = "page", source = "page.number"),
            @Mapping(target = "size", source = "page.size"),
            @Mapping(target = "totalPages", source = "page.totalPages"),
            @Mapping(target = "totalItems", source = "page.totalElements"),
            @Mapping(target = "sorted", expression = "java(!sortBy.isEmpty() &&!sortDirection.isEmpty())"),
            @Mapping(target = "sortBy", source = "sortBy"),
            @Mapping(target = "sortDirection", source = "sortDirection")
    })
    GenericResponseMeta mapToGenericResponseMeta(Page<?> page, String sortBy, String sortDirection);

    GenericResponse mapToGenericResponse(Object data, GenericResponseMeta meta, String message, HttpStatus status);

}
