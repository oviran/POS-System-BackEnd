package com.oshadhaviran.pointofsale.repo;

import com.oshadhaviran.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface CustomerRepo extends JpaRepository <Customer,Integer>{             //int- Cus id type


    List<Customer> findAllByActiveEquals(boolean status);


}
