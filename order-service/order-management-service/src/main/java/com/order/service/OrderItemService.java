package com.order.service;

import com.order.model.OrderItemModel;

import java.util.List;

public interface OrderItemService {

    OrderItemModel createNewOrder(OrderItemModel orderItemModel);

    List<OrderItemModel> getAllOrdersItemsByOrderId(Long orderId);

    OrderItemModel getOrderByOrderId(Long orderItemId);

    OrderItemModel updateOrderDetails(Long orderItemId, OrderItemModel orderItemModel);
}
