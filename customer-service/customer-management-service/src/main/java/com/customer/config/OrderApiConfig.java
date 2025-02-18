package com.customer.config;

import com.order.api.OrdersApi;
import com.order.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApiConfig {

//    @Value("${services.base-path.order-service}")
//    private String basePath;

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath("http://localhost:8082/order-service");
    }
    @Bean
    public OrdersApi ordersApi(){
        return new OrdersApi(apiClient());
    }

}
