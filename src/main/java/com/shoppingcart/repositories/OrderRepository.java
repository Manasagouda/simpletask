package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shoppingcart.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);

    @Modifying
    @Query("UPDATE Order o SET o.totalAmount = :amount WHERE o.id = :id")
    void updateOrderAmount(@Param("id") Long id, @Param("amount") double amount);
}
