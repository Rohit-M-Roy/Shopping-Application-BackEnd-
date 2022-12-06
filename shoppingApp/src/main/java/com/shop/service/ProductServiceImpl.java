package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.ProductException;
import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.repository.CategoryRepo;
import com.shop.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo prep;
	
	@Autowired
	CategoryRepo catRepo;

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
		Category addedCategory = catRepo.save(product.getCategory());
		product.setCategory(addedCategory);
		Product addedProduct = prep.save(product);
		
		return addedProduct;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException{
		
		Optional<Product> fetchedProduct = prep.findById(product.getProductId());
		
		if(fetchedProduct.isEmpty()) {
			throw new ProductException("no product in the database to update");
		}
		
		fetchedProduct.get().setColor(product.getColor());
		fetchedProduct.get().setDimension(product.getDimension());
		fetchedProduct.get().setPrice(product.getPrice());
		fetchedProduct.get().setQuantity(product.getQuantity());
		fetchedProduct.get().setSpecification(product.getSpecification());
		
		return prep.save(fetchedProduct.get());
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
