package com.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.CartException;
import com.shop.exception.CustomerException;
import com.shop.exception.ProductException;
import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.service.CartService;

@RestController
@RequestMapping(value = "/api/shopping")
public class CartController {
	
	@Autowired
	CartService cartServ;
	
	@PostMapping("/cart/{Cust_id}/{pid}/{quantity}")
	public ResponseEntity<Cart> addProductToCartHandler(@PathVariable("Cust_id") Integer customerId, @PathVariable("pid")Integer pid, @PathVariable("quantity")Integer quantity)throws CustomerException,ProductException{
		
		Cart cart = cartServ.addProductToCart(customerId, pid, quantity);
		
		return new ResponseEntity<Cart>(cart,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/cart/{Cust_id}/{pid}/{quantity}")
	public ResponseEntity<Cart> updateProductToCartHandler(@PathVariable("Cust_id") Integer customerId, @PathVariable("pid")Integer pid, @PathVariable("quantity")Integer quantity)throws CustomerException,ProductException{
		
		Cart cart = cartServ.addProductToCart(customerId, pid, quantity);
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/cart/{cartId}/{pid}")
	public ResponseEntity<Cart> deleteProductHandler(@PathVariable("cartId") Integer cartId, @PathVariable("pid")Integer pid)throws CustomerException,ProductException,CartException{
		
		Cart cart = cartServ.removeProductFromCart(cartId, pid);
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/cart/{cartId}")
	public ResponseEntity<String> removeAllProductsHandler(@PathVariable("cartId") Integer cartId)throws CartException{
		
		String message = cartServ.removeAllProducts(cartId);
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<Map<Product,Integer>> ViewAllProductsHandler(@PathVariable("cartId") Integer cartId)throws CartException{
		
		Map<Product,Integer> message = cartServ.VeiwAllProducts(cartId);
		
		return new ResponseEntity<Map<Product,Integer>>(message,HttpStatus.OK);
		
	}

}
