package com.customer.service.impl;

import com.customer.entity.Customer;
import com.customer.handler.NotFoundException;
import com.customer.mapper.CustomerMapper;
import com.customer.model.CustomerModel;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.order.api.OrdersApi;
import com.order.model.OrderModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.customer.utils.ResponseHelper.getSort;
import static com.customer.utils.ResponseHelper.mapToPageResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final OrdersApi ordersApi;

    @Override
    public CustomerModel signUp(CustomerModel customerModel) {
        log.debug("creating customer... ");
        Customer customer = customerMapper.mapToEntity(customerModel);
        Customer persistedCustomer = customerRepository.save(customer);
        log.debug("customer created successfully for customerId : {} ", persistedCustomer.getId());
        return customerMapper.mapToModel(persistedCustomer);
    }

    @Override
    public CustomerModel getCustomerDetails(Long customerId) {
        var customer = customerRepository.findById(customerId).orElseThrow(() ->
                new NotFoundException(String.format("customer not found for customerId : %s", customerId)));
        return customerMapper.mapToModel(customer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
        log.debug("customer deleted successfully for customerId : {} ", customerId);
    }

    @Override
    public Page<CustomerModel> getAllCustomers(Integer page, Integer size, String sortBy, String sortDirection) {
        List<OrderModel> allOrders = ordersApi.getAllOrders();
        var pageable = PageRequest.of(page, size, getSort(sortBy, sortDirection));
        var customerList = customerRepository.findAll(pageable);
        return mapToPageResponse(customerList, customerMapper::mapToModel);
    }

    @Override
    public CustomerModel updateCustomerDetails(CustomerModel customerModel) {
        log.debug("updating customer details for customerId : {} ", customerModel.getId());
        var customer = customerMapper.mapToEntity(customerModel);
        customerMapper.mapToModelToEntity(customerModel, customer);
        var persistedCustomer = customerRepository.save(customer);
        log.debug("customer details updated successfully for customerId : {} ", persistedCustomer.getId());
        return customerMapper.mapToModel(persistedCustomer);
    }
}
