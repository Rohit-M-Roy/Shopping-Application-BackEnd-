package com.shop.service;

import java.util.List;

import com.shop.exception.AddressException;
import com.shop.exception.CustomerException;
import com.shop.model.Address;

public interface AddressService {
	
	public Address addAddress(Address address, int customerId)throws CustomerException,AddressException;
	public Address updateAddress(Address address)throws AddressException;
	public Address removeAddress(int customerId)throws AddressException,CustomerException;
	public List<Address> viewAllAddress();
	public Address viewAddress(int customerId) throws CustomerException;

}
