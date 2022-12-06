package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.ProductException;
import com.shop.model.Product;
import com.shop.service.ProductService;

@RestController
@RequestMapping(value = "/api/shopping")
public class ProductController {
	
	@Autowired
	ProductService pserv;
	
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product product) throws ProductException{
		
		Product addedProduct = pserv.addProduct(product);
		
		return new ResponseEntity<Product>(addedProduct,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductException{
		
		Product updatedProduct = pserv.updateProduct(product);
		
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("id") Integer id)throws ProductException{
		
		Product deletedProduct = pserv.removeProduct(id);
		
		return new ResponseEntity<Product>(deletedProduct,HttpStatus.OK);
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> viewProductHandler(@PathVariable("id") Integer id)throws ProductException{
		
		Product view = pserv.viewProduct(id);
		
		return new ResponseEntity<Product>(view,HttpStatus.OK);
		
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProductHandler()throws ProductException{
		
		List<Product> list = pserv.viewAllProducts();
		
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		
	}

}
