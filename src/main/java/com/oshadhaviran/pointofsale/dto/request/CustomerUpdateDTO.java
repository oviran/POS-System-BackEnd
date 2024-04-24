package com.oshadhaviran.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerUpdateDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;

}



















//    public CustomerUpdateDTO(int customerId, String customerName, String customerAddress, double customerSalary) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.customerSalary = customerSalary;
//    }
//
//    public CustomerUpdateDTO() {
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public double getCustomerSalary() {
//        return customerSalary;
//    }
//
//    public void setCustomerSalary(double customerSalary) {
//        this.customerSalary = customerSalary;
//    }

