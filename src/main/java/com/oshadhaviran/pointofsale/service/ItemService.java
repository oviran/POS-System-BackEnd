package com.oshadhaviran.pointofsale.service;

import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.oshadhaviran.pointofsale.dto.request.ItemSaveRequestDTO;
import com.oshadhaviran.pointofsale.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {


    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);

}