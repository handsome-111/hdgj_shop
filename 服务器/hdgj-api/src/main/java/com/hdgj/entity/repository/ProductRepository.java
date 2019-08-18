package com.hdgj.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.ModelAttr;
import com.hdgj.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,String>{

}
