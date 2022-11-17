package com.shop.model;

import java.time.LocalDate;
import java.util.Map;

public class Orders {
	
	private Integer orderId;
	private LocalDate orderDate;
	private OrderStatus orderStatus;
	
	private Customer customer;
	
	private Map<Product,Integer> productListOrder;
	private Address address;

}
