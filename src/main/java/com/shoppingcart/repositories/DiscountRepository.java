package com.shoppingcart.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entities.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Optional<Discount> findByOrderId(Long orderId);
//
//    List<Discount> findByCustomerId(Long customerId);
}
