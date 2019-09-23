package com.hdgj.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.entity.Product;
import com.hdgj.entity.repository.ProductRepository;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("{itemId}")
	public ResponseData getProductByItemId(@PathVariable String itemId){
		Optional<Product> product = productRepository.findById(itemId);
		//System.out.println("product:" + product);
		return ResponseDataUtil.buildSuccess(product);
	}
}
