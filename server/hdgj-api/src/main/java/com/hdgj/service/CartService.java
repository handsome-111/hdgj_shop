package com.hdgj.service;

import java.util.List;

import com.hdgj.entity.Cart;

public interface CartService {

	/**
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	int addCart(Cart cart);
	
	List<Cart> getCarts(int userid);
	
	Cart getProductCartByUserid(Cart cart);
	
}
