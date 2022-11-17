package com.shop.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@OneToOne(mappedBy = "cart")
	private Customer customer;
	
	@OneToMany(fetch = FetchType.LAZY)
	@MapKeyClass(Product.class)
	@ElementCollection(targetClass = Integer.class)
	@JoinTable(name="cart_Product_List")
	Map<Product,Integer>productListCart = new HashMap<>();
//	private Map<Product,Integer> productListCart;
	

}
