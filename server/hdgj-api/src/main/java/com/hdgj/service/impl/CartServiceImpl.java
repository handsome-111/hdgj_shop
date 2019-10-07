package com.hdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.jaxb.PageAdapter;
import org.springframework.stereotype.Service;

import com.hdgj.entity.Cart;
import com.hdgj.entity.repository.CartRepository;
import com.hdgj.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public int addCart(Cart cart) {
		cartRepository.save(cart);
		return 0;
	}
	
	@Override
	public List<Cart> getCarts(int userid){
		return cartRepository.findAllByUserid(userid,PageRequest.of(0, 10,Sort.by(Direction.DESC,"updateTime")));
	}
	
	@Override
	public Cart getProductCartByUserid(Cart cart) {
		int userid = cart.getUserid();
		String productId = cart.getProduct().getId();
		return cartRepository.findByUseridAndProduct(userid, productId);
	}
}
