package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.AddressException;
import com.shop.exception.CustomerException;
import com.shop.model.Address;
import com.shop.model.Customer;
import com.shop.repository.AddressRepo;
import com.shop.repository.CustomerRepo;
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepo arep;
	@Autowired
	CustomerRepo crep;	

	@Override
	public Address addAddress(Address address, int customerId) throws CustomerException,AddressException {
		
		Customer checkForCustomerWithId = crep.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not in the database"));
		
		checkForCustomerWithId.setAddress(address);
		
		address  = arep.save(address);
		crep.save(checkForCustomerWithId);
		
		return address;
	}

	@Override
	public Address updateAddress(Address address) throws AddressException{
		
		Address checkAddress = arep.findById(address.getAddressId()).orElseThrow(()->new AddressException("No address with such id found"));
		
		checkAddress.setBuildingName(address.getBuildingName());
		checkAddress.setCity(address.getCity());
		checkAddress.setPincode(address.getPincode());
		checkAddress.setState(address.getState());
		checkAddress.setStreetNo(address.getStreetNo());
		
		Address updatedAddress = arep.save(checkAddress);
		
		return updatedAddress;
	}

	@Override
	public Address removeAddress(int customerId) throws AddressException,CustomerException {
		
		Customer fetchedCustomer = crep.findById(customerId).orElseThrow(()->new CustomerException("No such Customer in the database"));
		
		Address address = fetchedCustomer.getAddress();
		fetchedCustomer.setAddress(null);
		arep.delete(address);
		crep.save(fetchedCustomer);
		return address;
	}

	@Override
	public List<Address> viewAllAddress() {
		
		List<Address> listOfaddress= arep.findAll(); 
		
		return listOfaddress;
	}

	@Override
	public Address viewAddress(int customerId) throws CustomerException{
		
		Customer customer = crep.findById(customerId).orElseThrow(()->new CustomerException("No Customer found in the database"));
		
		Address address = customer.getAddress();
		
		return address;
	}

}
