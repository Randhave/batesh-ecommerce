package com.order.mapper;

import com.order.entity.Order;
import com.order.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderModel mapEntityToModel(Order order);

    Order mapToModelToEntity(OrderModel orderModel);

    void mapModelToEntity(@MappingTarget OrderModel orderModel, Order order);
}
