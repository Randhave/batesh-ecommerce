package com.order.config;

import com.product.ApiClient;
import com.product.api.ProductsApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApiConfig {

//    @Value("${services.base-path.product-service}")
//    private String basePath;

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath("http://localhost:8081/product-service");
    }

    @Bean
    public ProductsApi productsApi() {
        return new ProductsApi(apiClient());
    }

}
