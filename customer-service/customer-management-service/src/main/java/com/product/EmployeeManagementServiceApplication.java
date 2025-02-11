package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementServiceApplication.class, args);
        System.out.println("Product-management-service running...");
    }

}
