package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Customer;
import com.shop.model.User;
import com.shop.repository.CustomerRepo;
import com.shop.repository.UserRepo;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo crep;
	
	@Autowired
	UserRepo urep;

	@Override
	public Customer addCustomer(Customer customer) {
		
		User fetchedUser = urep.findById(customer.getEmail()).orElseThrow();//exception
		
		Customer savedCustomer = crep.save(customer);
		
		return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomer) {
		
		Customer fetchedCustomer = crep.findById(updatedCustomer.getCustomerId()).orElseThrow();//exception);
		
		fetchedCustomer.setFirstName(updatedCustomer.getFirstName());
		fetchedCustomer.setLastName(updatedCustomer.getLastName());
		fetchedCustomer.setAge(updatedCustomer.getAge());
		fetchedCustomer.setGender(updatedCustomer.getGender());
		fetchedCustomer.setMobileNumber(updatedCustomer.getMobileNumber());
		
		crep.save(fetchedCustomer);
		
		return fetchedCustomer;
	}

	@Override
	public Customer removeCustomer(int id) {
		
		Customer deletedCustomer = crep.findById(id).orElseThrow(); //exception
		crep.delete(deletedCustomer);
		
		return deletedCustomer;
	}

	@Override
	public Customer viewCustomer(int id) {
		
		Customer fetchedCustomer = crep.findById(id).orElseThrow(); //Exception
		
		return fetchedCustomer;
	}

	@Override
	public List<Customer> veiwAllCustomer() {
		
		List<Customer> customerList = crep.findAll();
		
		if(customerList.isEmpty()) {
			//Exception
		}
		
		return customerList;
	}

}
