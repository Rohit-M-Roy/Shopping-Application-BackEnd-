package com.shop.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.shop.enums.CustomerGender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
	
	@Id
	private Integer customerId;
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private CustomerGender gender;
	private Integer age;
	private String mobileNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId", referencedColumnName = "addressId")
	private Address address;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "cartId")
	private Cart cart;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Orders> customer_Orders;

}
