package com.order.service.impl;

import com.order.model.OrderModel;
import com.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderModel createNewOrder(OrderModel orderModel) {
        return null;
    }

    @Override
    public List<OrderModel> getAllOrders() {
        return null;
    }

    @Override
    public OrderModel getOrderByOrderId(Long orderId) {
        return null;
    }

    @Override
    public OrderModel updateOrderDetails(Long orderId, OrderModel orderModel) {
        return null;
    }
}
