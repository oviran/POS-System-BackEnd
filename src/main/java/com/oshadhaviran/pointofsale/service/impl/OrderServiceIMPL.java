package com.oshadhaviran.pointofsale.service.impl;

import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.oshadhaviran.pointofsale.dto.paginated.PaginatedResponseOrderDTO;
import com.oshadhaviran.pointofsale.dto.queryInterface.OrderDetailInterface;
import com.oshadhaviran.pointofsale.dto.request.RequestOrderSaveDTO;
import com.oshadhaviran.pointofsale.dto.response.ItemGetResponseDTO;
import com.oshadhaviran.pointofsale.dto.response.OrderGetResponseDTO;
import com.oshadhaviran.pointofsale.entity.Item;
import com.oshadhaviran.pointofsale.entity.Order;
import com.oshadhaviran.pointofsale.entity.OrderDetails;
import com.oshadhaviran.pointofsale.repo.CustomerRepo;
import com.oshadhaviran.pointofsale.repo.ItemRepo;
import com.oshadhaviran.pointofsale.repo.OrderDetailRepo;
import com.oshadhaviran.pointofsale.repo.OrderRepo;
import com.oshadhaviran.pointofsale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private ItemRepo itemRepo;


    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {           //different types.cann't use mapping
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomers()),
                requestOrderSaveDTO.isActiveState(),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()

        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {

            List<OrderDetails> orderDetails = modelMapper.map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>() {
            }.getType());
            for (int i = 0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getReferenceById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if (orderDetails.size() > 0) {
                orderDetailRepo.saveAll(orderDetails);
            }
            return order.getOrderId() + " Saved Successfully";
        } else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public PaginatedResponseOrderDTO getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailInterface> orderDetailInterfaces  = orderRepo.getAllOrderDetails(status, PageRequest.of(page, size));
        if (orderDetailInterfaces.size() > 0) {
            List<OrderGetResponseDTO> orderGetResponseDTO = modelMapper.map(orderDetailInterfaces, new TypeToken<List<OrderGetResponseDTO>>() {
            }.getType());

            PaginatedResponseOrderDTO paginatedResponseItemDTO = new PaginatedResponseOrderDTO(orderGetResponseDTO, orderRepo.countAllByActiveStateOrderEquals(status)
            );
            return paginatedResponseItemDTO;
        } else {
            throw new RuntimeException("Order is Not Active");
        }


    }


}
