package com.oshadhaviran.pointofsale.dto.request;


import com.oshadhaviran.pointofsale.entity.Customer;
import com.oshadhaviran.pointofsale.entity.OrderDetails;
import com.oshadhaviran.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class RequestOrderSaveDTO {

    private int customers;
    private boolean activeState;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSave> orderDetails;



}
