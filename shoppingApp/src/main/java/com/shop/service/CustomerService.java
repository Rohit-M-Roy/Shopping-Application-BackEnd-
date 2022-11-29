package com.shop.service;

import java.util.List;

import com.shop.model.Customer;
import com.shop.model.User;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer updatedCustomer);
	public Customer removeCustomer(int id);
	public Customer viewCustomer(int id);
	public List<Customer> veiwAllCustomer();

}
