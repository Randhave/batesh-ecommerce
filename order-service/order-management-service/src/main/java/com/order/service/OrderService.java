package com.order.service;

import com.order.model.OrderModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    OrderModel createNewOrder(OrderModel orderModel);

    Page<OrderModel> getAllOrders(Integer page, Integer size, String sortBy, String sortDirection);

    OrderModel getOrderByOrderId(Long orderId);

    OrderModel updateOrderDetails(Long orderId, OrderModel orderModel);

    void deleteOrderByOrderId(Long id);

}
