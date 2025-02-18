package com.customer.service;

import com.example.employee.model.CustomerModel;
import org.springframework.data.domain.Page;

public interface CustomerService {

    CustomerModel signUp(CustomerModel customerModel);

    CustomerModel getCustomerDetails(Long customerId);

    void deleteCustomer(Long customerId);

    Page<CustomerModel> getAllCustomers(Integer page, Integer size, String sortBy, String sortDirection);

    CustomerModel updateCustomerDetails(CustomerModel customerModel);
}
