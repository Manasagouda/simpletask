package com.shoppingcart.dto;

import com.shoppingcart.entities.Customer;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
  //  private Long customerId;
    
    private Customer customer;
    
    private Double totalAmount;
    // Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Long getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(Long customerId) {
//		this.customerId = customerId;
//	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
    
}
