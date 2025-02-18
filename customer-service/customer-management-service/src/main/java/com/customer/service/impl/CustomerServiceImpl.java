package com.customer.service.impl;

import com.customer.mapper.CustomerMapper;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.example.employee.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerModel signUp(CustomerModel customerModel) {
        return null;
    }

    @Override
    public CustomerModel getCustomerDetails(Long customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Page<CustomerModel> getAllCustomers(Integer page, Integer size, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public CustomerModel updateCustomerDetails(CustomerModel customerModel) {
        return null;
    }
}
