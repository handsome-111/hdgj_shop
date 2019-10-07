package com.hdgj.entity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.Cart;

public interface CartRepository extends PagingAndSortingRepository<Cart, String>{
	
	//@Query(fields="{'userid':1}",sort="{}")
	public List<Cart> findAllByUserid(int userid,Pageable page);
	
	public Cart findByUseridAndProduct(int userid,String product);
}
