package com.hdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.hdgj.entity.ShopProduct;
import com.hdgj.service.ShopProductService;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@RestController
@RequestMapping(value="/shopProduct")
public class ShopProductController {
	
	@Autowired
	private ShopProductService shopProductService;
	
	@RequestMapping("/getShopProducts")
	public ResponseData getShopProducts(@RequestParam("page") int page,@RequestParam("size") int size){
		JSONArray data = shopProductService.sortShopProductList(page, size);
		
		return ResponseDataUtil.buildSuccess(data);
	}
}
