package com.hdgj.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.Cart;
import com.hdgj.entity.Product;
import com.hdgj.service.CartService;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/addCart")
	public ResponseData addCart(@RequestParam("cart") String jsonStr){
		Cart cart = JSONObject.parseObject(jsonStr, Cart.class);

		Cart findCart = cartService.getProductCartByUserid(cart);
		long now = new Date().getTime();

		
		if(findCart == null){
			cart.setNumber(1);
			cart.setCreateTime(now);
			cart.setUpdateTime(now);
			cartService.addCart(cart);
			return ResponseDataUtil.buildSuccess();
		}
		
		int number = findCart.getNumber();
		number++;
		findCart.setNumber(number);
		findCart.setUpdateTime(now);
		cartService.addCart(findCart);
		
		return ResponseDataUtil.buildSuccess();
	} 

	/**
	 * 获取用户指定商品的购物车
	 * @return
	 */
	@RequestMapping("/getCartByUserid")
	public ResponseData getCartByUseridAndProduct(){
		Cart cart = new Cart();
		int userid = 11;
		String productId = "2938455289";
		
		cart.setUserid(userid);
		Product p = new Product();
		p.setId(productId);
		cart.setProduct(p);
		
		Cart c = cartService.getProductCartByUserid(cart);
		System.out.println(c);
		return ResponseDataUtil.buildSuccess(c);
	}
	
	@GetMapping("/getCarts")
	public ResponseData getCarts(@RequestParam int userid){
		List<Cart> carts = cartService.getCarts(userid);
		return ResponseDataUtil.buildSuccess(carts);
	}
	/**
	 * 购物车更新
	 * @return
	 */
	@GetMapping("/updateCart")
	public ResponseData updateCart(@RequestParam("cart") String jsonStr){
		Cart cart = JSONObject.parseObject(jsonStr, Cart.class);
		cart.setUpdateTime(new Date().getTime());
		cart = cartService.updateCart(cart);
		return ResponseDataUtil.buildSuccess(cart);
	}
	

}



