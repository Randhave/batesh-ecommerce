package com.order.controller;

import com.order.api.OrderItemsApi;
import com.order.model.OrderItemModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client-api/v1")
@Slf4j
public class OrderItemController implements OrderItemsApi {

    @Override
    public ResponseEntity<OrderItemModel> createOrderItem(OrderItemModel orderItemModel) {
        log.info("Creating new order item with id: {}", orderItemModel.getOrderItemId());
        log.info("Order item details: {}", orderItemModel);
        // Add order item creation logic here
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteOrderItem(Long orderItemId) {
        log.info("Deleting order item with id: {}", orderItemId);
        // Add order item deletion logic here
        return null;
    }

    @Override
    public ResponseEntity<OrderItemModel> getOrderItemById(Long orderItemId) {
        log.info("Retrieving order item with id: {}", orderItemId);
        // Add order item retrieval logic here
        return null;
    }

    @Override
    public ResponseEntity<OrderItemModel> updateOrderItem(Long orderItemId, OrderItemModel orderItemModel) {
        log.info("Updating order item with id: {}", orderItemId);
        log.info("Updated order item details: {}", orderItemModel);
        // Add order item update logic here
        return null;
    }
}
