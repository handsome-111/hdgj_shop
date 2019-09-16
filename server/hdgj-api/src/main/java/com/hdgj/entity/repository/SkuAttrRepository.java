package com.hdgj.entity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hdgj.entity.Sku;


public interface SkuAttrRepository extends MongoRepository<Sku,String>{
	
}
