package com.order.controller;

import com.order.api.OrdersApi;
import com.order.model.GenericResponse;
import com.order.model.OrderModel;
import com.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.order.utils.ResponseHelper.returnGenericResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController implements OrdersApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<GenericResponse> createNewOrder(OrderModel orderModel) {
        log.info("Creating new order with id: {}", orderModel.getOrderId());
        var orders = orderService.createNewOrder(orderModel);
        log.info("Order details: {}", orderModel);
        return returnGenericResponse(orders, "New order placed successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> deleteOrderById(Long id) {
        log.info("Deleting order with id: {}", id);
        orderService.deleteOrderByOrderId(id);
        return returnGenericResponse(Boolean.TRUE, "Order deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getAllOrders(Integer page, Integer size, String sortBy, String sortDirection) {
        log.info("Retrieving all orders");
        var allOrders = orderService.getAllOrders(page, size, sortBy, sortDirection);
        // Add order retrieval logic here
        return returnGenericResponse(allOrders,"Orders fetched successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getOrderById(Long id) {
        log.info("Retrieving order with id: {}", id);
        return returnGenericResponse(orderService.getOrderByOrderId(id),"Order details fetched successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> updateOrder(Long id, OrderModel orderModel) {
        log.info("Updating order with id: {}", id);
        var updateOrderDetails = orderService.updateOrderDetails(id, orderModel);
        log.info("Updated order details: {}", orderModel);
        return returnGenericResponse(updateOrderDetails,"Orders details updated successfully", HttpStatus.OK);
    }
}
