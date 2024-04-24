package com.oshadhaviran.pointofsale.controller;

import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseOrderDTO;
import com.oshadhaviran.pointofsale.dto.request.ItemSaveRequestDTO;
import com.oshadhaviran.pointofsale.dto.request.RequestOrderSaveDTO;
import com.oshadhaviran.pointofsale.service.OrderService;
import com.oshadhaviran.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin

public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/save")

    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String message = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, message + " Successfully", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-order-details",
            params = {"stateType","page","size"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value="stateType") String stateType,
            @RequestParam(value="page") int page,
            @RequestParam(value="size") int size
    ) {
        PaginatedResponseOrderDTO paginatedResponseOrderDTO = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            paginatedResponseOrderDTO = orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseOrderDTO),
                HttpStatus.OK
        );

    }
}
