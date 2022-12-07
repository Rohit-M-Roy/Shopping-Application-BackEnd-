package com.shop.service;

import java.util.Map;

import com.shop.exception.CartException;
import com.shop.exception.CustomerException;
import com.shop.exception.ProductException;
import com.shop.model.Cart;
import com.shop.model.Product;

public interface CartService {
	
	public Cart addProductToCart(Integer customerId, Integer pid, Integer q)throws CustomerException,ProductException;
	public Cart removeProductFromCart(Integer cartId, Integer pid)throws CustomerException,ProductException,CartException;
//	public Cart updateProductQuantity(Integer cartId, Integer pid, Integer q)throws CartException,CustomerException;
	public String removeAllProducts(Integer cartId)throws CartException;
	public Map<Product,Integer> VeiwAllProducts(Integer cartId)throws CartException;

}
