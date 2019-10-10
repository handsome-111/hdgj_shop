package com.hdgj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hdgj.entity.Product;
import com.hdgj.entity.repository.ProductRepository;
import com.hdgj.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> getProductById(String itemId){
		return productRepository.findById(itemId);
	}

}
