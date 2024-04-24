package com.oshadhaviran.pointofsale.service.impl;

import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.oshadhaviran.pointofsale.dto.request.ItemSaveRequestDTO;
import com.oshadhaviran.pointofsale.dto.response.ItemGetResponseDTO;
import com.oshadhaviran.pointofsale.entity.Item;
import com.oshadhaviran.pointofsale.exception.NotFoundException;
import com.oshadhaviran.pointofsale.repo.ItemRepo;
import com.oshadhaviran.pointofsale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {

        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + " Saved Successfully";

        } else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {
            }.getType());

            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("Item is Not Active");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus,int page ,int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        int count =itemRepo.countAllByActiveStateEquals(activeStatus);
        if (items.getSize() < 1) {
            throw new RuntimeException("No Data");
        }

        List<ItemGetResponseDTO> itemGetResponseDTOS = items.stream()
                .map(item -> modelMapper.map(item, ItemGetResponseDTO.class))
                .collect(Collectors.toList());



        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(itemGetResponseDTOS,count
        );
        return paginatedResponseItemDTO;
    }

}
