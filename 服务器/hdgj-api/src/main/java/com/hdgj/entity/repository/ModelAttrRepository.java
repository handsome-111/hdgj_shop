package com.hdgj.entity.repository;

import org.apache.ibatis.annotations.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hdgj.entity.ModelAttr;

public interface ModelAttrRepository extends MongoRepository<ModelAttr, String>{
	
	

}
