package com.order.service.impl;

import com.order.handler.NotFoundException;
import com.order.mapper.OrderMapper;
import com.order.model.OrderModel;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import com.product.api.ProductsApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.order.utils.ResponseHelper.getSort;
import static com.order.utils.ResponseHelper.mapToPageResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final ProductsApi productsApi;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderModel createNewOrder(OrderModel orderModel) {
        var savedOrderDetails = orderRepository.save(orderMapper.mapToModelToEntity(orderModel));
        log.debug("order created success fully for orderId : {}", savedOrderDetails.getOrderId());
        return orderMapper.mapEntityToModel(savedOrderDetails);
    }

    @Override
    public Page<OrderModel> getAllOrders(Integer page, Integer size, String sortBy, String sortDirection) {
        //var allProducts = productsApi.getAllProducts(0,10,null,null);
        var pageable = PageRequest.of(page, size, getSort(sortBy, sortDirection));
        var allOrders = orderRepository.findAll(pageable);
        return mapToPageResponse(allOrders, orderMapper::mapEntityToModel);
    }

    @Override
    public OrderModel getOrderByOrderId(Long orderId) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with id: {}" + orderId));
        log.debug("order found successfully for orderId : {}", orderId);
        return orderMapper.mapEntityToModel(order);
    }

    @Override
    public OrderModel updateOrderDetails(Long orderId, OrderModel orderModel) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with id: {}" + orderId));
        orderMapper.mapModelToEntity(orderModel, order);
        var updatedOrderDetails = orderRepository.save(order);
        log.debug("order details updated successfully for orderId : {}", orderId);
        return orderMapper.mapEntityToModel(updatedOrderDetails);
    }

    @Override
    public void deleteOrderByOrderId(Long id) {
        orderRepository.deleteById(id);
        log.debug("order deleted successfully by orderId : {}", id);
    }
}
