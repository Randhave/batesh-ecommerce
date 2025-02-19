package com.order.controller;

import com.order.api.PaymentsApi;
import com.order.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController implements PaymentsApi {

    @Override
    public ResponseEntity<PaymentModel> createPayment(PaymentModel paymentModel) {
        log.info("Creating new payment with id: {}", paymentModel.getPaymentId());
        log.info("Payment details: {}", paymentModel);
        // Add payment creation logic here
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePayment(Long paymentId) {
        log.info("Deleting payment with id: {}", paymentId);
        // Add payment deletion logic here
        return null;
    }

    @Override
    public ResponseEntity<List<PaymentModel>> getPayments() {
        log.info("Retrieving all payments");
        // Add payment retrieval logic here
        return null;
    }

    @Override
    public ResponseEntity<PaymentModel> updatePayment(Long paymentId, PaymentModel paymentModel) {
        log.info("Updating payment with id: {}", paymentId);
        log.info("Updated payment details: {}", paymentModel);
        // Add payment update logic here
        return null;
    }
}
