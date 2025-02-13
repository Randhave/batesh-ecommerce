package com.order.service;

import com.order.model.ShippingModel;

public interface ShippingService {

    ShippingModel shiftOrder(ShippingModel shippingModel);

    ShippingModel getShippingDetailsByOrderId(Long orderId);

    ShippingModel getShippingDetailsByShippingId(Long shippingId);
}
