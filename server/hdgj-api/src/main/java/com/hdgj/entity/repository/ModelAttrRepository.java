package com.hdgj.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.ModelAttr;

public interface ModelAttrRepository extends PagingAndSortingRepository<ModelAttr,String>{
	ModelAttr findByAttrTitle(String attrTitle);
	
}
