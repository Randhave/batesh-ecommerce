package com.customer.mapper;

import com.customer.entity.Customer;
import com.customer.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerModel mapToModel(Customer customer);

    Customer mapToEntity(CustomerModel customerModel);

    List<CustomerModel> mapToCustomerModelList(List<Customer> customersList);

    void mapToModelToEntity(CustomerModel customerModel, @MappingTarget Customer customer);
}
