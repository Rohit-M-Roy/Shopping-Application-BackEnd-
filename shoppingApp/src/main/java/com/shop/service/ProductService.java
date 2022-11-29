package com.shop.service;

import java.util.List;

import com.shop.model.Product;

public interface ProductService {
	
	public List<Product> viewAllProducts();
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product viewProduct(int id);
	public List<Product> veiwProductByCategory(String catgoryName);
	public Product removeProduct(int pid);

}
