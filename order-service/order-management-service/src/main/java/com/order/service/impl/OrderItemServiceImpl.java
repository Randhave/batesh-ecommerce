package com.order.service.impl;

import com.order.model.OrderItemModel;
import com.order.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public OrderItemModel createNewOrder(OrderItemModel orderItemModel) {
        return null;
    }

    @Override
    public List<OrderItemModel> getAllOrdersItemsByOrderId(Long orderId) {
        return null;
    }

    @Override
    public OrderItemModel getOrderByOrderId(Long orderItemId) {
        return null;
    }

    @Override
    public OrderItemModel updateOrderDetails(Long orderItemId, OrderItemModel orderItemModel) {
        return null;
    }
}
