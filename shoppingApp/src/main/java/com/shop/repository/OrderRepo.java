package com.shop.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByorderDate(LocalDate date);

}
