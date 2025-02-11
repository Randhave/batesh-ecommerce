package com.product.controller;

import com.order.api.OrdersApi;
import com.order.model.OrderModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-api/v1")
@Slf4j
@RequiredArgsConstructor
public class OrderController implements OrdersApi {


    @Override
    public ResponseEntity<OrderModel> createNewOrder(OrderModel orderModel) {
        log.info("hello");
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteOrderById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<OrderModel> getOrderById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<OrderModel> updateOrder(Long id, OrderModel orderModel) {
        return null;
    }
}
