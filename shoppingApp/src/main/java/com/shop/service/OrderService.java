package com.shop.service;

import java.time.LocalDate;
import java.util.List;

import com.shop.exception.CustomerException;
import com.shop.exception.OrderException;
import com.shop.model.Orders;

public interface OrderService {
	
	public Orders addOrder(Orders order, Integer customerId)throws CustomerException;
	public Orders updateOrderDetails(Orders order)throws OrderException;
	public Orders removeOrder(Orders order) throws OrderException;
	public Orders viewOrder(Orders order) throws OrderException;
	public List<Orders> viewOrdersByDate(LocalDate date)throws OrderException;
//	public List<Orders> viewOrdersByLocation(String location);
	public List<Orders> viewOrdersByUserId(int userId)throws CustomerException,OrderException;

}
