package com.shop.service;

import java.util.List;

import com.shop.exception.CustomerException;
import com.shop.model.Customer;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer)throws CustomerException;
	public Customer updateCustomer(Customer updatedCustomer)throws CustomerException;
	public Customer removeCustomer(int id);
	public Customer viewCustomer(int id);
	public List<Customer> veiwAllCustomer();

}
