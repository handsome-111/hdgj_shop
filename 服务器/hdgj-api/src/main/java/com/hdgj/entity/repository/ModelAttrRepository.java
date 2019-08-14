package com.hdgj.entity.repository;

import org.springframework.data.repository.Repository;

import com.hdgj.entity.ModelAttr;

public interface ModelAttrRepository extends Repository<ModelAttr, String>{
	ModelAttr findByAttrTitle(String attrTitle);
}
