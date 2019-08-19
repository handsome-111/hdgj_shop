package com.hdgj.entity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,String>{
	@Query("select item_id from product")
	List<String> getItemIds(Pageable page);
}
