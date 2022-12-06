package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.CustomerException;
import com.shop.model.Customer;
import com.shop.service.CustomerService;

@RestController
@RequestMapping(value = "/api/shopping")
public class CustomerController {
	
	@Autowired
	CustomerService cserv;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer)throws CustomerException{
		
		Customer addedCustomer = cserv.addCustomer(customer);
		
		return new ResponseEntity<Customer>(addedCustomer, HttpStatus.OK);
		
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer updatedCustomer) throws CustomerException{
		
		Customer updatedCust = cserv.updateCustomer(updatedCustomer);
		
		return new ResponseEntity<Customer>(updatedCust,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> removeCustomerHandler(@PathVariable("id") Integer customerId){
		
		Customer deletedCustomer = cserv.removeCustomer(customerId);
		
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> viewCustomerHandler(@PathVariable("id") Integer customerId){
		
		Customer viewCustomer = cserv.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(viewCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> veiwAllCustomerHandler(){
		
		List<Customer> list = cserv.veiwAllCustomer();
		
		return new ResponseEntity<List<Customer>>(list,HttpStatus.ACCEPTED);
		
	}

}
