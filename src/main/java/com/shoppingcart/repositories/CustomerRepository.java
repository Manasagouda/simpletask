package com.shoppingcart.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shoppingcart.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   // Optional<Customer> findByEmail(String email);
    //List<Customer> findByOrderCountGreaterThan(int orderCount);

//    @Modifying
//    @Query("UPDATE Customer c SET c.customerType = :type WHERE c.id = :id")
//    void updateCustomerType(@Param("id") Long id, @Param("type") String type);
}
