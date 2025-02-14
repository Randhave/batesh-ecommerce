package com.order.controller;

import com.order.api.OrdersApi;
import com.order.model.OrderModel;
import com.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-api/v1")
@Slf4j
@RequiredArgsConstructor
public class OrderController implements OrdersApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<OrderModel> createNewOrder(OrderModel orderModel) {
        log.info("Creating new order with id: {}", orderModel.getOrderId());
        var orders = orderService.createNewOrder(orderModel);
        log.info("Order details: {}", orderModel);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteOrderById(Long id) {
        log.info("Deleting order with id: {}", id);
        orderService.deleteOrderByOrderId(id);
        return null;
    }

    @Override
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        log.info("Retrieving all orders");
        var allOrders = orderService.getAllOrders();
        // Add order retrieval logic here
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderModel> getOrderById(Long id) {
        log.info("Retrieving order with id: {}", id);
        var order = orderService.getOrderByOrderId(id);
        // Add order retrieval logic here
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderModel> updateOrder(Long id, OrderModel orderModel) {
        log.info("Updating order with id: {}", id);
        var updateOrderDetails = orderService.updateOrderDetails(id, orderModel);
        log.info("Updated order details: {}", orderModel);
        return new ResponseEntity<>(updateOrderDetails, HttpStatus.OK);
    }
}
