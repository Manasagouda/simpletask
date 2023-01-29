package com.shoppingcart.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingcart.dto.CustomerDto;
import com.shoppingcart.entities.Customer;
import com.shoppingcart.repositories.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDto customerDto) {
        // Create new customer object from DTO and set default type as "regular"
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setOrderCount(customerDto.getOrderCount());
        customer.setType(customerDto.getCustomerType());
        
        return customerRepository.save(customer);
    }

    public Customer updateCustomerType(Long customerId, String customerType) {
        // Retrieve customer from repository
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            // Update customer type
            customer.setType(customerType);
            return customerRepository.save(customer);
            
        } else {
        	return null;
        }
    }

    public void incrementOrderCount(Long customerId) {
        // Retrieve customer from repository
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            // Increment order count
            customer.setOrderCount(customer.getOrderCount() + 1);
            customerRepository.save(customer);
        } 
    }

	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
