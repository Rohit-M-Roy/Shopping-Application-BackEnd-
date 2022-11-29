package com.shop.service;

import java.util.List;

import com.shop.model.Address;

public interface AddressService {
	
	public Address addAddress(Address address);
	public Address updateAddress(Address address);
	public Address removeAddress(int customerId);
	public List<Address> viewAllAddress();
	public Address viewAddress(int customerId);

}
