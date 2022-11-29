package com.shop.service;

import java.time.LocalDate;
import java.util.List;

import com.shop.model.Orders;

public interface OrderService {
	
	public Orders addOrder(Orders order);
	public Orders updateOrder(Orders order);
	public Orders removeOrder(Orders order);
	public Orders viewOrder(Orders order);
	public List<Orders> viewOrdersByDate(LocalDate date);
	public List<Orders> viewOrdersByLocation(String location);
	public List<Orders> viewOrdersByUserId(int userId);

}
