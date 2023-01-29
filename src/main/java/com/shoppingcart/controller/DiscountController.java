package com.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entities.Discount;
import com.shoppingcart.services.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Discount>> getDiscountsByCustomerId(@PathVariable Long customerId) {
        List<Discount> discounts = discountService.getDiscountsByCustomerId(customerId);
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Discount> getDiscountByOrderId(@PathVariable Long orderId) {
        Discount discount = discountService.getDiscountByOrderId(orderId);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}
