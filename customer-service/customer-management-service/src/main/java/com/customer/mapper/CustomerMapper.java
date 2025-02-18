package com.customer.mapper;

import com.customer.entity.Customer;
import com.example.employee.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerModel mapToModel(Customer customer);

    Customer mapToEntity(CustomerModel customerModel);

    List<CustomerModel> mapToCustomerModelList(List<Customer> customersList);
}
