package com.hdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.hdgj.entity.Cate;
import com.hdgj.entity.repository.CateRespository;
import com.hdgj.service.CateService;

@Service
public class CateServiceImpl implements CateService{
	@Autowired
	private CateRespository cateRespository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Cate save(Cate cate){
		if(cate == null){
			return null;
		}
		return cateRespository.save(cate);
	}

	@Override
	public Iterable<Cate> saveAll(List<Cate> cates) {
		if(cates == null){
			return null;
		}
		Criteria crit = new Criteria();
		//crit.
		//mongoTemplate.updateMulti(Query., update, entityClass)
		//mongoTemplate.findAndModify(query, update, Cate.class);
		return  cateRespository.saveAll(cates);
	}
	
}
