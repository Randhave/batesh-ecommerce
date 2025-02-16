//package com.order.config;
//
//import com.product.ApiClient;
//import com.product.apis.ProductsApi;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class ProductApiConfig {
//
//    @Bean
//    public ApiClient apiClient() {
//        return new ApiClient();
//    }
//
////    private ProductsApi productsApi(){
////        return new ProductsApi(apiClient());
////    }
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.rootUri("http://localhost:8080/product-service").build();
//    }
//}
