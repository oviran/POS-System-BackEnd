package com.oshadhaviran.pointofsale.dto.response;

import com.oshadhaviran.pointofsale.dto.request.RequestOrderDetailsSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderGetResponseDTO {
    //customer
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;

    //order
    private Date date;
    private Double total;



}
