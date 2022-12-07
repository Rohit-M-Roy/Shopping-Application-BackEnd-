package com.shop.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.CartException;
import com.shop.exception.CustomerException;
import com.shop.exception.ProductException;
import com.shop.model.Cart;
import com.shop.model.Customer;
import com.shop.model.Product;
import com.shop.repository.CartRepo;
import com.shop.repository.CustomerRepo;
import com.shop.repository.ProductRepo;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepo crep;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ProductRepo prep;

	@Override
	public Cart addProductToCart(Integer customerId, Integer pid, Integer q) throws CustomerException,ProductException{
		
		Customer getCustomer = customerRepo.findById(customerId).orElseThrow(()-> new CustomerException("No Such Customer in the database"));
		
		Cart cart = getCustomer.getCart();
		Product p = prep.findById(pid).orElseThrow(()-> new ProductException("No Product witht the given product Id"));
		
		Map<Product,Integer> mapOfProducts = cart.getProductListCart();
		
		if(mapOfProducts.containsKey(p)) {
			mapOfProducts.put(p, mapOfProducts.get(p)+q);
		}else {
			
			mapOfProducts.put(p, q);
			
		}
		
		crep.save(cart);
		customerRepo.save(getCustomer);
		
		p.setQuantity(p.getQuantity()-q);
		
		if(p.getQuantity() < 0) {
			throw new ProductException("Not sufficient quantity in the warehouse");
		}
		
		prep.save(p);
	
		return cart;
	}

	@Override
	public Cart removeProductFromCart(Integer cartid, Integer pid) throws CustomerException,ProductException,CartException{
		
		Cart getCart = crep.findById(cartid).orElseThrow(()-> new CartException("No cart by the given id, Provide a valid cart Id"));
		Product p = prep.findById(pid).orElseThrow(()-> new ProductException("No Product witht the given product Id"));
		Integer quantity = getCart.getProductListCart().get(p);
		//recheck customer in the customer table
		Customer checkCustomer = customerRepo.findById(getCart.getCustomer().getCustomerId()).orElseThrow(()-> new CustomerException("No Customer availabe in the Customer database"));
		
		getCart.getProductListCart().remove(p);
		
		Cart savedCart = crep.save(getCart);
		customerRepo.save(checkCustomer);
		//adding quantity back to product dB
		p.setQuantity(p.getQuantity()+quantity);
		prep.save(p);
		return savedCart;
	}

//	@Override
//	public Cart updateProductQuantity(Integer cartId, Integer pid, Integer q) throws CartException,CustomerException{
//		
//		Cart getCart = crep.findById(cartId).orElseThrow(()-> new CartException("No Cart with this cart Id"));
//		
//		Customer getCustomerFromcart = getCart.getCustomer();
//		
//		//recheck customer in the customer table
//		Customer checkCustomer = customerRepo.findById(getCart.getCustomer().getCustomerId()).orElseThrow(()-> new CustomerException("No Customer availabe in the Customer database"));
//		
//		Map<Product,Integer> map = getCart.getProductListCart();
//		
//		map.put(p, map.getOrDefault(p, q)+q);
//		
//		crep.save(getCart);
//		customerRepo.save(checkCustomer);
//		
//		return getCart;
//	}

	@Override
	public String removeAllProducts(Integer cartId) throws CartException {
		
		Cart getCart = crep.findById(cartId).orElseThrow(()-> new CartException("No Such Cart with the provided cartid"));
		
		getCart.getProductListCart().clear();
		
		crep.save(getCart);
		customerRepo.save(getCart.getCustomer());
		
		return "Cart Cleared";
	}

	@Override
	public Map<Product,Integer> VeiwAllProducts(Integer cartId) throws CartException{
		
		Cart getCart = crep.findById(cartId).orElseThrow(()-> new CartException("No Such Cart with the provided cartid"));
		
		Map<Product,Integer> listOfProductsWithQuantity = getCart.getProductListCart();
		
		return listOfProductsWithQuantity;
	}

}
