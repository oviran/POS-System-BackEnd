package com.oshadhaviran.pointofsale.service;

import com.oshadhaviran.pointofsale.dto.CustomerDTO;
import com.oshadhaviran.pointofsale.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);


    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean status);
}
