package com.product.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
    private String description;
}
