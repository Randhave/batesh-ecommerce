package com.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeeManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementServiceApplication.class, args);
        log.info("order-management-service running...");
    }

}
