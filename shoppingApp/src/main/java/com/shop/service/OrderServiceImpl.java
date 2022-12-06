package com.shop.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.CustomerException;
import com.shop.exception.OrderException;
import com.shop.model.Customer;
import com.shop.model.Orders;
import com.shop.repository.CustomerRepo;
import com.shop.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo orep;
	
	@Autowired
	CustomerRepo crep;

	@Override
	public Orders addOrder(Orders order, Integer customerId) throws CustomerException{
		
		Customer getCustomer = crep.findById(customerId).orElseThrow(()-> new CustomerException("No Customer in the database with the provided Id"));
		
		getCustomer.getCustomer_Orders().add(order);
		
		crep.save(getCustomer);
		
		return orep.save(order);
	}

	@Override
	public Orders updateOrderDetails(Orders order)throws OrderException {
		
		Orders fetchedOrder = orep.findById(order.getOrderId()).orElseThrow(()-> new OrderException("No Mathching Order in the database"));
		
		fetchedOrder.setOrderStatus(order.getOrderStatus());
		
		orep.save(fetchedOrder);
		crep.save(fetchedOrder.getCustomer());
		return null;
	}

	@Override
	public Orders removeOrder(Orders order) throws OrderException {
		
		Orders fetchedOrder = orep.findById(order.getOrderId()).orElseThrow(()-> new OrderException("No Mathching Order in the database"));
		
		Customer getCustomerFromFetchedOrder = fetchedOrder.getCustomer();
		
		getCustomerFromFetchedOrder.getCustomer_Orders().remove(fetchedOrder);
		
		crep.save(getCustomerFromFetchedOrder);
		orep.delete(fetchedOrder);
		
		
		
		return fetchedOrder;
	}

	@Override
	public Orders viewOrder(Orders order) throws OrderException {
		
		Orders fetchedOrder = orep.findById(order.getOrderId()).orElseThrow(()-> new OrderException("No Mathching Order in the database"));
		
		
		
		return fetchedOrder;
	}

	@Override
	public List<Orders> viewOrdersByDate(LocalDate date) throws OrderException{
		
		List<Orders> listOfOrders = orep.findByorderDate(date);
		
		if(listOfOrders.size() == 0) {
			throw new OrderException("No orders on this Date");
		}
		
		
		
		return listOfOrders;
	}

//	@Override
//	public List<Orders> viewOrdersByLocation(String location) {
//		
//		
//		
//		return null;
//	}

	@Override
	public List<Orders> viewOrdersByUserId(int userId) throws CustomerException,OrderException {
		
		Customer fetchedCustomer = crep.findById(userId).orElseThrow(()-> new CustomerException("No User By the provided UserId"));
		
		List<Orders> listOfOrders = new ArrayList<>(fetchedCustomer.getCustomer_Orders());
		
		return listOfOrders;
	}

}
