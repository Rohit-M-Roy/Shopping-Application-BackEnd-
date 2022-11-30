package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	public Product findByproductName(String name);

}
