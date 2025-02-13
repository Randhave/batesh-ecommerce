package com.order.service.impl;

import com.order.model.PaymentModel;
import com.order.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentModel makePayment(PaymentModel paymentModel) {
        return null;
    }

    @Override
    public PaymentModel getPaymentDetailsByPaymentId(Long paymentId) {
        return null;
    }

    @Override
    public PaymentModel getPaymentDetailsByOrderId(Long orderId) {
        return null;
    }
}
