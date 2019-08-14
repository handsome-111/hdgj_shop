package com.hdgj.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.hdgj.entity.ModelAttr;

public interface ModelAttrRepository extends QueryByExampleExecutor<ModelAttr>{
	ModelAttr findByAttrTitle(String attrTitle);
}
