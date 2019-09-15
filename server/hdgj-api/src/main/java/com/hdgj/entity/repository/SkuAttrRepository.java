package com.hdgj.entity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.hdgj.entity.Sku3;


public interface SkuAttrRepository extends MongoRepository<Sku3,String>{
	
}
