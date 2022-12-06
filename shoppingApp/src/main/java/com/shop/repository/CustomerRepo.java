package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public Optional<Customer> findByemail(String email);

}
