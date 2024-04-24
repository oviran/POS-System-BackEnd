package com.oshadhaviran.pointofsale.repo;


import com.oshadhaviran.pointofsale.dto.queryInterface.OrderDetailInterface;
import com.oshadhaviran.pointofsale.entity.Customer;
import com.oshadhaviran.pointofsale.entity.Item;
import com.oshadhaviran.pointofsale.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order,Integer>{

    @Query(value = "select c.customer_name as customerName ,c.customer_address as customerAddress,c.contact_number as contactNumber,o.order_date as date,o.total as total from customer c , orders o where o.active_state =?1 and c.customer_id = o.customer_id",nativeQuery = true )
    List<OrderDetailInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value = "select count(*) from customer c , orders o where o.active_state =?1 and c.customer_id = o.customer_id",nativeQuery = true )
    long countAllByActiveStateOrderEquals(boolean status);
}
