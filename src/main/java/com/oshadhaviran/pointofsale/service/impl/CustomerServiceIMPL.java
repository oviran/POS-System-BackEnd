package com.oshadhaviran.pointofsale.service.impl;

import com.oshadhaviran.pointofsale.dto.CustomerDTO;
import com.oshadhaviran.pointofsale.dto.request.CustomerUpdateDTO;
import com.oshadhaviran.pointofsale.entity.Customer;
import com.oshadhaviran.pointofsale.entity.Item;
import com.oshadhaviran.pointofsale.entity.OrderDetails;
import com.oshadhaviran.pointofsale.exception.NotFoundException;
import com.oshadhaviran.pointofsale.repo.CustomerRepo;
import com.oshadhaviran.pointofsale.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + "  update successfully";
        } else {
            throw new RuntimeException("no data found for that id");
        }


    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
            return customerDTO;
        } else {
            throw new RuntimeException("no data found for that id");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        if (getAllCustomers.size() > 0) {
            List<CustomerDTO> customerDTOList = modelMapper.map(getAllCustomers, new TypeToken<List<CustomerDTO>>() {
            }.getType());
            return customerDTOList;
        } else {
            throw new NotFoundException("No Customer Found");

        }

    }

    @Override
    public String deleteCustomer(int customerId) {

        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Deleted successfully " + customerId;


        } else {
            throw new RuntimeException("No Customer Found in that ID");

        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean status) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(status);

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }


}
