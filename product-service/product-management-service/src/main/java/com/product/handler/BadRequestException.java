package com.product.handler;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException{
    private String message;
}
