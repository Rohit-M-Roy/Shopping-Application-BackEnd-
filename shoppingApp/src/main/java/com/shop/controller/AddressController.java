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

import com.shop.exception.AddressException;
import com.shop.exception.CustomerException;
import com.shop.model.Address;
import com.shop.service.AddressService;

@RestController
@RequestMapping(value = "/api/shopping")
public class AddressController {
	
	@Autowired
	AddressService aserv;
	
	@PostMapping("/address/{Cust_id}")
	public ResponseEntity<Address> addAddressHandler(@PathVariable("Cust_id") Integer customerId, @RequestBody Address address)throws CustomerException,AddressException{
		
		Address savedAddress = aserv.addAddress(address, customerId);
		
		return new ResponseEntity<Address>(savedAddress,HttpStatus.OK);
		
	}
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddressHandler(@RequestBody Address address)throws AddressException{
		
		Address updatedAddress = aserv.updateAddress(address);
		
		return new ResponseEntity<Address>(updatedAddress,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/address/{cust_id}")
	public ResponseEntity<Address> deleteAddressHandler(@PathVariable("cust_id") Integer customerId)throws AddressException,CustomerException{
		
		Address deletedAddress = aserv.removeAddress(customerId);
		
		return new ResponseEntity<Address>(deletedAddress,HttpStatus.OK);
		
	}
	
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> viewAllAddressHandler(){
		
		List<Address> list = aserv.viewAllAddress();
		
		return new ResponseEntity<List<Address>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/address/{cust_id}")
	public ResponseEntity<Address> viewAddressHandler(@PathVariable("cust_id") Integer customerId)throws CustomerException{
		
		Address view = aserv.viewAddress(customerId);
		
		return new ResponseEntity<Address>(view,HttpStatus.OK);
	}

}
