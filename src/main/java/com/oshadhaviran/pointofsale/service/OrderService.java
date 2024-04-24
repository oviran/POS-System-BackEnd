package com.oshadhaviran.pointofsale.service;

import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseOrderDTO;
import com.oshadhaviran.pointofsale.dto.request.RequestOrderSaveDTO;

public interface OrderService {

    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);


    PaginatedResponseOrderDTO getAllOrderDetails(boolean status, int page, int size);
}
