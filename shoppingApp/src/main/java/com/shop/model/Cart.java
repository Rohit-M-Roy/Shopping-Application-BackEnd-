package com.shop.model;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Customer customer;
	
//	@OneToMany(fetch = FetchType.LAZY)
	@ElementCollection
	@CollectionTable(name="cart_product_list", joinColumns = {@JoinColumn}) 
	@MapKeyJoinColumn(name="product_Id")
	@Column(name="quantity")
	private Map<Product,Integer> productListCart;
	

}
