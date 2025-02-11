package com.product.controller;

import com.example.employee.api.EmployeeApi;
import com.example.employee.model.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-api/v1")
public class EmployeeController implements EmployeeApi {

    @Override
    public ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return null;
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployeeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return null;
    }
}
