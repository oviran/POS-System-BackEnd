package com.oshadhaviran.pointofsale.controller;

import com.oshadhaviran.pointofsale.dto.CustomerDTO;
import com.oshadhaviran.pointofsale.dto.request.CustomerUpdateDTO;
import com.oshadhaviran.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin                                  //frontend address unique

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")

    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping ("/update")

    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping (
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam (value ="id") int customerId) {

        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customers"
    )

    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;


    }
    @DeleteMapping(
            path =  "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable (value ="id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return  deleted;
    }

    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )

    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable boolean status) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(status);
        return allCustomers;

    }






}
