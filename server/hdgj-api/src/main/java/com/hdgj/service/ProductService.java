package com.hdgj.service;

import java.util.List;
import java.util.Optional;

import com.hdgj.entity.Product;

public interface ProductService {
	Optional<Product> getProductById(String itemId);
}
