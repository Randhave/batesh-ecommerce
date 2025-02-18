package com.customer.controller;

import com.customer.api.CustomersApi;
import com.customer.model.CustomerModel;
import com.customer.service.CustomerService;
import com.customer.model.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.customer.utils.Constants.*;
import static com.customer.utils.ResponseHelper.returnGenericResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CustomerController implements CustomersApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<GenericResponse> createNewCustomer(CustomerModel customerModel) {
        log.info("creating new customer ");
        var newlyCreatedCustomer = customerService.signUp(customerModel);
        log.info("customer created successfully for customerId : {} ", newlyCreatedCustomer.getId());
        return returnGenericResponse(newlyCreatedCustomer, CUSTOMER_CREATED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(Long id) {
        log.info("deleting customer for customerId : {} ", id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(CUSTOMER_DELETED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getAllCustomers(Integer page, Integer size, String sortBy, String sortDirection) {
        log.info("fetching customers for page : {}, size : {} & sortBy : {}, sortDirection : {}", page, size, sortBy, sortDirection);
        var allCustomers = customerService.getAllCustomers(page, size, sortBy, sortDirection);
        return returnGenericResponse(allCustomers, CUSTOMERS_FETCHED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> getCustomerById(Long id) {
        log.info("fetching customer details for customerId : {} ", id);
        var customerDetails = customerService.getCustomerDetails(id);
        return returnGenericResponse(customerDetails, CUSTOMER_DETAILS_FETCHED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> updateCustomer(CustomerModel customerModel) {
        log.info("updating customer details for customerId : {} ", customerModel.getId());
        var updateCustomerDetails = customerService.updateCustomerDetails(customerModel);
        return returnGenericResponse(updateCustomerDetails, CUSTOMER_UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }
}
