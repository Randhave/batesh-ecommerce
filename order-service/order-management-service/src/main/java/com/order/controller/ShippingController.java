package com.order.controller;

import com.order.api.ShippingsApi;
import com.order.model.ShippingModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShippingController implements ShippingsApi {

    @Override
    public ResponseEntity<ShippingModel> createShipping(ShippingModel shippingModel) {
        log.info("Creating new shipping with id: {}", shippingModel.getShippingId());
        log.info("Shipping details: {}", shippingModel);
        // Add shipping creation logic here
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteShipping(Long shippingId) {
        log.info("Deleting shipping with id: {}", shippingId);
        // Add shipping deletion logic here
        return null;
    }

    @Override
    public ResponseEntity<List<ShippingModel>> getShipping() {
        log.info("Retrieving all shippings");
        // Add shipping retrieval logic here
        return null;
    }

    @Override
    public ResponseEntity<ShippingModel> updateShipping(Long shippingId, ShippingModel shippingModel) {
        log.info("Updating shipping with id: {}", shippingId);
        log.info("Updated shipping details: {}", shippingModel);
        // Add shipping update logic here
        return null;
    }
}
