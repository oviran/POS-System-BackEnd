package com.oshadhaviran.pointofsale.dto.request;

import com.oshadhaviran.pointofsale.entity.Item;
import com.oshadhaviran.pointofsale.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestOrderDetailsSave {

    private String itemName;
    private String sellingPrice;
    private double Qty;
    private Double amount;
    private int orders;
    private int items;






}
