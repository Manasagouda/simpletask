package com.shoppingcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingcart.entities.Customer;
import com.shoppingcart.entities.Discount;
import com.shoppingcart.repositories.CustomerRepository;
import com.shoppingcart.repositories.DiscountRepository;
@Service
public class DiscountService {
	private CustomerRepository customerRepo;
	private DiscountRepository discountRepo;
	
	
	public DiscountService(CustomerRepository customerRepo, DiscountRepository discountRepo) {
		super();
		this.customerRepo = customerRepo;
		this.discountRepo = discountRepo;
	}

	public List<Discount> getDiscountsByCustomerId(Long customerId) {
		Optional<Customer> findById = customerRepo.findById(customerId);
		if(findById.isPresent()) {
		List<Discount> discounts = discountRepo.findAll();
		return discounts;
		}else{
			return null;
		}
	}

	public Discount getDiscountByOrderId(Long orderId) {
		Optional<Discount> discount = discountRepo.findByOrderId(orderId);
		Discount discount2 = discount.get();
		return discount2;
	}

	public void applyDiscount(Long id, Long id2, int i) {
		
	}

}
