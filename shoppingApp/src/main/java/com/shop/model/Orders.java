package com.shop.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;

import com.shop.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer orderId;
	private LocalDate orderDate;
	private OrderStatus orderStatus;
	
	@ManyToOne
	private Customer customer;
	
	@ElementCollection
	@CollectionTable(name="order_product_list", joinColumns = {@JoinColumn}) 
	@MapKeyJoinColumn(name="product_Id")
	@Column(name="quantity")
	private Map<Product,Integer> productListOrder;

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(orderId, other.orderId);
	}
	
	
	

}
