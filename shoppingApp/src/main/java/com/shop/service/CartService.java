package com.shop.service;

import com.shop.model.Cart;
import com.shop.model.Product;

public interface CartService {
	
	public Cart addProductToCart(Cart cart, Product p, Integer q);
	public Cart removeProductFromCart(Cart cart, Product p);
	public Cart updateProductQuantity(Cart cart, Product p, Integer q);
	public Cart removeAllProducts(Cart cart);
	public Cart VeiwAllProducts(Cart cart);

}
