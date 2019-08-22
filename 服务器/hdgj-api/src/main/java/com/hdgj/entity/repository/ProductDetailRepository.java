package com.hdgj.entity.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.ProductDetail;

public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail,String>{
	List<ProductDetail> findByItemId(String itemId);
	
	Number deleteByItemId(String itemId);
}
