package com.oshadhaviran.pointofsale.controller;

import com.oshadhaviran.pointofsale.dto.CustomerDTO;
import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.oshadhaviran.pointofsale.dto.request.ItemSaveRequestDTO;
import com.oshadhaviran.pointofsale.dto.response.ItemGetResponseDTO;
import com.oshadhaviran.pointofsale.service.ItemService;
import com.oshadhaviran.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")

    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value="name") String itemName) {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemGetResponseDTOS),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemByActiveStatus(
            @RequestParam(value="activeStatus") boolean activeStatus,
            @RequestParam(value="page") int page,
            @RequestParam(value="size") int size

    ) {
//        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByActiveStatus(activeStatus,page,size);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }









}
