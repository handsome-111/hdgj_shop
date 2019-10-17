package com.hdgj.entity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.ShopProduct;

public interface ShopProductRepository extends PagingAndSortingRepository<ShopProduct,String> {
	/*@Query(fields="{'itemId':1}")
	List<ShopProduct> getAllBy(Pageable page);*/
	
	@Query(fields="{'itemId':1}")
	List<JSONObject> findAllBy(Pageable page);

}
