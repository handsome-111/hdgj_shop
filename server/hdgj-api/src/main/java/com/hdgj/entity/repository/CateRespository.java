package com.hdgj.entity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hdgj.entity.Cate;

public interface CateRespository extends PagingAndSortingRepository<Cate, Long>{
	@Query(fields="{'cateId':1}")
	List<String> findAllBy();
}
