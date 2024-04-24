package com.oshadhaviran.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="customer")
@TypeDefs({
        @TypeDef(name="json", typeClass = JsonType.class)
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Customer {


    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String customerAddress;

    @Column(name = "customer_salary",length = 10)
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_number",columnDefinition = "json",length =10)
    private ArrayList contactNumber;

    @Column(name = "nic" ,length = 13)
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0 ")
    private boolean active;

    @OneToMany(mappedBy="customers")           //Ref-Baeldung site
    private Set<Order> order;
}





















//    public Customer() {           //noArgs
//    }
//
//    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList contactNumber, String nic, boolean active) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.customerSalary = customerSalary;
//        this.contactNumber = contactNumber;
//        this.nic = nic;
//        this.active = active;
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
//
//    public ArrayList getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(ArrayList contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public String getNic() {
//        return nic;
//    }
//
//    public void setNic(String nic) {
//        this.nic = nic;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId=" + customerId +
//                ", customerName='" + customerName + '\'' +
//                ", customerAddress='" + customerAddress + '\'' +
//                ", customerSalary=" + customerSalary +
//                ", contactNumber=" + contactNumber +
//                ", nic='" + nic + '\'' +
//                ", active=" + active +
//                '}';
//    }

