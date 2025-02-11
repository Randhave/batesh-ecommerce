package com.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProductManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementServiceApplication.class, args);
        log.info("product-management-service running...");
    }

}
