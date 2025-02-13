package com.order.service;

import com.order.model.PaymentModel;

public interface PaymentService {

    PaymentModel makePayment(PaymentModel paymentModel);

    PaymentModel getPaymentDetailsByPaymentId(Long paymentId);

    PaymentModel getPaymentDetailsByOrderId(Long orderId);
}
