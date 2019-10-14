package com.hdgj.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
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
	
	
	public void upsertAll(List<Cate> cates){
		if(cates == null){
			return ;
		}
		for(Cate cate : cates){
			Criteria crit = new Criteria();
			crit.where("_id").is(cate.getCateId());
			Cate c = mongoTemplate.findAndReplace(Query.query(crit), cate);
			System.out.println("已经更新的Cate:" + cate);
		}
	}

	@Override
	public List<Long> getIdsAll() {
		List<String> idsJson = cateRespository.findAllBy();
		List<Long> ids = new LinkedList<Long>();
		for(String id : idsJson){
			JSONObject json = (JSONObject) JSONObject.parse(id);
			Long i = Long.parseLong((String) ((JSONObject)json.get("_id")).get("$numberLong"));
			ids.add(i);
		}
		
		return ids;
	}

	@Override
	public void removeIds(List<Long> ids) { 
		List<Cate> cates = new LinkedList<Cate>();
		Cate cate = new Cate();
		for(Long id : ids){
			cate.setCateId(id); 
			cates.add(cate); 
		}
		cateRespository.deleteAll(cates);
	} 
} 
 



