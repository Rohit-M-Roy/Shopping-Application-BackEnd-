package com.shop.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.enums.CustomerGender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@JsonIgnore
	private Cart cart;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Orders> customer_Orders;
	
	
	

}
