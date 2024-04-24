package com.oshadhaviran.pointofsale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemGetResponseDTO {

    private int itemId;
    private String itemName;
    private double balanceQty;
    private String supplierPrice;
    private String sellingPrice;
    private boolean activeState;

}
