package com.order.service;

import com.order.model.OrderModel;

import java.util.List;

public interface OrderService {

    OrderModel createNewOrder(OrderModel orderModel);

    List<OrderModel> getAllOrders();

    OrderModel getOrderByOrderId(Long orderId);

    OrderModel updateOrderDetails(Long orderId, OrderModel orderModel);
}
