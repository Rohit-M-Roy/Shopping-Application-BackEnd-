package com.shop.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{
	
	@Query(value = "select u from Orders u where u.orderDate = ?1")
	public List<Orders> findByorderDate(LocalDate date);

}
