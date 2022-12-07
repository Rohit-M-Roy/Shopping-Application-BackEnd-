package com.shop.controller;

import java.time.LocalDate;
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

import com.shop.exception.CartException;
import com.shop.exception.CustomerException;
import com.shop.exception.OrderException;
import com.shop.model.Orders;
import com.shop.service.OrderService;

@RestController
@RequestMapping(value = "/api/shopping")
public class OrderController {
	
	@Autowired
	OrderService orderserv;
	
	@PostMapping("/order/{custId}")
	public ResponseEntity<Orders> addOrderHandler(@RequestBody Orders order,@PathVariable("custId") Integer customerId)throws CustomerException,CartException{
		
		Orders createdOrder = orderserv.addOrder(order, customerId);
		
		return new ResponseEntity<Orders>(createdOrder,HttpStatus.OK);
	}
	
	@PutMapping("/order/")
	public ResponseEntity<Orders> updateOrderHandler(@RequestBody Orders order)throws OrderException{
		
		Orders updatedOrder = orderserv.updateOrderDetails(order);
		
		return new ResponseEntity<Orders>(updatedOrder,HttpStatus.OK);
	}
	
	@DeleteMapping("/order/{Order_id}")
	public ResponseEntity<Orders> deletedOrderHandler(@PathVariable("Order_id") Integer orderId) throws OrderException{
		
		Orders deletedOrder = orderserv.removeOrder(orderId);
		
		return new ResponseEntity<Orders>(deletedOrder,HttpStatus.OK);
		
	}
	
	@GetMapping("/order/{Order_id}")
	public ResponseEntity<Orders> viewOrderHandler(@PathVariable("Order_id") Integer orderId) throws OrderException{
		
		Orders viewOrder = orderserv.viewOrder(orderId);
		
		return new ResponseEntity<Orders>(viewOrder,HttpStatus.OK);
		
	}
	
	@GetMapping("/orders/{userId}")
	public ResponseEntity<List<Orders>> viewOrdersByUserIdHandler(@PathVariable("userId") Integer orderId) throws OrderException,CustomerException{
		
		List<Orders> viewOrder = orderserv.viewOrdersByUserId(orderId);
		
		return new ResponseEntity<List<Orders>>(viewOrder,HttpStatus.OK);
		
	}
	
	@GetMapping("/ordersByDate/{date}")
	public ResponseEntity<List<Orders>> viewOrdersByDateHandler(@PathVariable("date") LocalDate date) throws OrderException{
		
		List<Orders> viewOrder = orderserv.viewOrdersByDate(date);
		
		return new ResponseEntity<List<Orders>>(viewOrder,HttpStatus.OK);
		
	}
	
	
	
	

	
	
	
	

}
