package com.hdgj.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.AttrValue;

public interface AttrValueRepository extends PagingAndSortingRepository<AttrValue, Number>{
	AttrValue findByAttrId(Number attrId);
	long countByAttrId(Number attrId);
}
