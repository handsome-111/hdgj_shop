 package com.hdgj.other.vd.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.ModelAttr;
import com.hdgj.entity.repository.ModelAttrRepository;
import com.hdgj.entity.repository.SkuAttrRepository;
import com.hdgj.other.vd.api.ProductService;
import com.weidian.open.sdk.exception.OpenException;

@Service
public class SyncVdService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SkuAttrRepository SkuAttrResponse;
	
	@Autowired
	private ModelAttrRepository modelAttrRepository;
	
	public void syncSkuAttr(){
		String response = "";
		try {
			response = productService.vdianSkuAttrsGet();
		} catch (OpenException e) {
			e.printStackTrace();
		}
		JSONObject res = JSON.parseObject(response);
		String status = res.getJSONObject("status").getString("status_code");
		
		String attrList = res.getJSONObject("result").getString("attr_list");
		List<ModelAttr> models = new ArrayList<ModelAttr>();
		models = JSON.parseArray(attrList, ModelAttr.class);
		
		/**
		 * 获取属性值集合
		 */
		List<String> attrTitles = new ArrayList<String>();
		Iterator<ModelAttr> ite = models.iterator();
		
		while(ite.hasNext()){
			attrTitles.add(ite.next().getAttrTitle());
		}
		
		System.out.println("集合:" + attrList);
		System.out.println("是否为空:" + models);
		System.out.println("attrTitle:" + attrTitles);
		
		/*Query query = new Query();
		Update update = Update.fromDocument(object, exclude)
		mongoTemplate.updateMulti("attrTitle", update, entityClass)*/
		Query query = Query.query(Criteria.where("attrTitles").in(attrTitles));
		document.
		Update update = Update.fromDocument("attr_title", attrList);
		mongoTemplate.upsert(query, update, ModelAttr.class);	
		System.out.println("结束");
	}
	
	public void test(){
		String res = "";
		try {
			res = productService.vdianItemGetItemDetail(2761295251L);
		} catch (OpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
	}

	
}
