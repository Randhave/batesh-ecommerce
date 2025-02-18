package com.customer.controller;

import com.customer.service.CustomerService;
import com.example.employee.api.CustomersApi;
import com.example.employee.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CustomerController implements CustomersApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerModel> createNewEmployee(CustomerModel customerModel) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteEmployeeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CustomerModel>> getAllEmployees(Integer page, Integer size, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerModel> getEmployeeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerModel> updateEmployee(Long id, CustomerModel customerModel) {
        return null;
    }
}
