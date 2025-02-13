package com.order.service.impl;

import com.order.model.ShippingModel;
import com.order.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {
    @Override
    public ShippingModel shiftOrder(ShippingModel shippingModel) {
        return null;
    }

    @Override
    public ShippingModel getShippingDetailsByOrderId(Long orderId) {
        return null;
    }

    @Override
    public ShippingModel getShippingDetailsByShippingId(Long shippingId) {
        return null;
    }
}
