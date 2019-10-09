package com.hdgj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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

		//获取库存
		int stock = cart.getProduct().getStock().intValue();
		
		//库存不足,无法加入购物车
		if(stock <= 0){
			return ResponseDataUtil.buildError("库存不足");
		}
		
		Cart findCart = cartService.getProductCartByUserid(cart);
		long now = new Date().getTime();

		//库存已达到最大值,无法继续添加
		if(findCart != null && stock <= findCart.getNumber()){
			return ResponseDataUtil.buildError("已达到库存最大值,无法继续添加");
		}
		
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
		/*Map<String,Cart> carts = new HashMap<String,Cart>();
		
		List<Cart> list = cartService.getCarts(userid);
		for(int i = 0; i < list.size(); i++){
			Cart cart = list.get(i);
			carts.put(cart.getId(),cart);
		}*/
		
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
	
	@GetMapping("/removeCart")
	public ResponseData removeCart(@RequestParam("ids")String jsonStr){
		JSONArray ids = JSON.parseArray(jsonStr);
		
		/**
		 * 装载所有的购物车
		 */
		List<Cart> carts = new ArrayList<Cart>();
		Cart cart = new Cart();
		for(int i = 0; i < ids.size(); i++){
			cart.setId(ids.getString(i));
			carts.add(cart);
		}
		
		
		cartService.deleteCart(carts);
		return ResponseDataUtil.buildSuccess(ids);
	}

}



