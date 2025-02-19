package com.customer.config;

import com.order.ApiClient;
import com.order.api.OrdersApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApiConfig {

    @Value("${services.base-path.order-service}")
    private String orderServiceUrl;

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath(orderServiceUrl);
    }

    @Bean
    public OrdersApi ordersApi() { return new OrdersApi(apiClient());
    }

}
