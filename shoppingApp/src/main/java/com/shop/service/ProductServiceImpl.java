package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.exception.ProductException;
import com.shop.model.Product;
import com.shop.repository.ProductRepo;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo prep;

	@Override
	public List<Product> viewAllProducts() {
		
		List<Product> listOfproduct = prep.findAll();
		
		
		
		return listOfproduct;
	}

	@Override
	public Product addProduct(Product product)throws ProductException {
		
		Product checkProduct = prep.findByproductName(product.getProductName());
		
		if(checkProduct != null) {
			throw new ProductException("Product Already in the database");
		}
		
		Product addedProduct = prep.save(product);
		
		return addedProduct;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException{
		
		Product fetchedProduct = prep.findByproductName(product.getProductName());
		
		if(fetchedProduct == null) {
			throw new ProductException("no product in the database to update");
		}
		
		fetchedProduct.setCategory(product.getCategory());
		fetchedProduct.setColor(product.getColor());
		fetchedProduct.setDimension(product.getDimension());
		fetchedProduct.setPrice(product.getPrice());
		fetchedProduct.setQuantity(product.getQuantity());
		fetchedProduct.setSpecification(product.getSpecification());
		
		return prep.save(fetchedProduct);
	}

	@Override
	public Product viewProduct(int id) throws ProductException {
		
		Product fetchedProduct = prep.findById(id).orElseThrow(()-> new ProductException("No such Product in the database"));
		
		
		return fetchedProduct;
	}

	@Override
	public List<Product> veiwProductByCategory(String catgoryName) {
		
		//custom Query
		
		return null;
	}

	@Override
	public Product removeProduct(int pid)throws ProductException  {
		
		Product fetchedProduct = prep.findById(pid).orElseThrow(()-> new ProductException("No such Product in the database"));
		prep.deleteById(pid);
		
		return fetchedProduct;
	}

}
