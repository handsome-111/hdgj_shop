package com.hdgj.service;

import java.util.List;

import com.hdgj.entity.Cart;
import com.hdgj.entity.repository.CartRepository;

public interface CartService{

	/**
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	Cart addCart(Cart cart);
	
	List<Cart> getCarts(int userid);
	
	Cart getProductCartByUserid(Cart cart);
	
	Cart updateCart(Cart cart);
	
	int deleteCart(List<Cart> carts);
}
