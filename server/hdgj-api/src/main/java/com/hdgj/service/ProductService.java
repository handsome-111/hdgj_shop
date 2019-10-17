package com.hdgj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.Product;

public interface ProductService {
	Optional<Product> getProductById(String itemId);
	List<JSONObject> findAllBy(PageRequest page);
}
