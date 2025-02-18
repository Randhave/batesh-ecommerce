package com.customer.utils;


import com.customer.mapper.GenericResponseMapper;
import com.customer.mapper.GenericResponseMapperImpl;
import com.customer.model.GenericResponse;
import com.customer.model.GenericResponseMeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResponseHelper {
    private static final GenericResponseMapper genericResponseMapper = new GenericResponseMapperImpl();

    private ResponseHelper() {
    }

    public static ResponseEntity<GenericResponse> returnGenericResponse(Object data, String message, HttpStatus status) {
        GenericResponseMeta genericResponseMeta;
        Object content;
        if (data instanceof Page page) {
            var pageable = page.getPageable();
            var sort = pageable.getSort();
            var sortBy = sort.isEmpty() ? "" : sort.toList().get(0).getProperty();
            var sortDirection = sort.isEmpty() ? "" : sort.toList().get(0).getDirection().toString();
            genericResponseMeta = genericResponseMapper.mapToGenericResponseMeta(page, sortBy, sortDirection);
            content = page.getContent();
        } else {
            genericResponseMeta = null;
            content = data;
        }
        return new ResponseEntity<>(genericResponseMapper.mapToGenericResponse(content, genericResponseMeta, message, status), status);
    }

    public static Sort getSort(String sortBy, String sortDirection) {
        var sort = Sort.by(sortBy);
        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        return sort;
    }

    public static <T, E> Page<T> mapToPageResponse(Page<E> page, Function<E, T> mapper) {
        var content = page.getContent().stream().map(mapper).toList();
        return new PageImpl<>(content, page.getPageable(), page.getTotalElements());
    }

}
