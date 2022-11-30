package com.shop.service;

import java.util.List;

import com.shop.exception.ProductException;
import com.shop.model.Product;

public interface ProductService {
	
	public List<Product> viewAllProducts();
	public Product addProduct(Product product)throws ProductException;
	public Product updateProduct(Product product)throws ProductException;
	public Product viewProduct(int id)throws ProductException;
	public List<Product> veiwProductByCategory(String catgoryName);
	public Product removeProduct(int pid)throws ProductException;

}
