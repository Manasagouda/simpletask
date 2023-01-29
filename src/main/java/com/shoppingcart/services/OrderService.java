package com.shoppingcart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dto.OrderDto;
import com.shoppingcart.entities.Customer;
import com.shoppingcart.entities.Order;
import com.shoppingcart.repositories.CustomerRepository;
import com.shoppingcart.repositories.OrderRepository;

@Service
	public class OrderService {
	    private  OrderRepository orderRepository;
	    private CustomerService customerService;
	    private  DiscountService discountService;

	    @Autowired
	    private CustomerRepository customerRepo;
	    
	    public OrderService(OrderRepository orderRepository, CustomerService customerService, DiscountService discountService) {
	        this.orderRepository = orderRepository;
	        this.customerService = customerService;
	        this.discountService = discountService;
	    }

	    public Order createOrder(long customerId, OrderDto orderDto) {
	    	Optional<Customer> optional = customerRepo.findById(customerId);
//	    	int orderCount=0;
//	    	String type="regular";
//	        // Retrieve customer associated with the order
	        //Customer customer1 = customerService.getCustomerById(orderDto.getCustomerId());
	        // Check customer's order count
	        if(optional.isPresent()) {
	        	Customer customer = optional.get();
	             // Increment order count
	            customer.setOrderCount(customer.getOrderCount() + 1);
	            
	         int orderCount = customer.getOrderCount();
	        if (orderCount >= 10) {
	            // Update customer type to "gold" and apply 10% discount to order
	            customerService.updateCustomerType(customer.getId(), "gold");
	            discountService.applyDiscount(customer.getId(), orderDto.getId(), 10);
	        }
	        if (orderCount >= 20) {
	            // Update customer type to "platinum" and apply 20% discount to order
	            customerService.updateCustomerType(customer.getId(), "platinum");
	            discountService.applyDiscount(customer.getId(), orderDto.getId(), 20);
	        }
	        // Create new order object from DTO
	        Order order = new Order();
	        //order.setCustomer(orderDto.getCustomer());
	       
	        order.setTotalAmount(orderDto.getTotalAmount());
	        order.setCustomer(customer);
	        orderRepository.save(order);
	        return order;}
	        else {
	        	return null;
	        }
	}

		public Order getOrderById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}


}
