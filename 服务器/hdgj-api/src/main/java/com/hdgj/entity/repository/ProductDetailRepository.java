package com.hdgj.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.ProductDetail;

public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail,String>{
	ProductDetail findByItemId(String itemId);
}
