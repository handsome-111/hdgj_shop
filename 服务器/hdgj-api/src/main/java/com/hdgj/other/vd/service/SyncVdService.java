 package com.hdgj.other.vd.service;

import java.util.Iterator;
import java.util.List;

import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.AttrValue;
import com.hdgj.entity.ModelAttr;
import com.hdgj.entity.repository.ModelAttrRepository;
import com.hdgj.entity.repository.SkuAttrRepository;
import com.hdgj.other.vd.api.ProductService;
import com.mongodb.client.MongoCollection;
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
		
		JSONArray attrList = res.getJSONObject("result").getJSONArray("attr_list");
		Iterator ite = attrList.iterator();
		System.out.println("attr_list:" + attrList.toJSONString());

		
		while(ite.hasNext()){
			//型号属性对象
			JSONObject modelAttr = (JSONObject) ite.next();
			
			/**
			 * 同步属性值
			 */
			JSONArray attrValues = modelAttr.getJSONArray("attr_values");
			Iterator attrvIterator = attrValues.iterator();
			while(attrvIterator.hasNext()){
				JSONObject attvObj = (JSONObject) attrvIterator.next();
				System.out.println("null:" + attvObj.get("attr_id"));
				String attrValue = attvObj.getString("attr_value");
				Update update = new Update();
				update.set("attr_id", attvObj.get("attr_id"));
				update.set("attr_value", attrValue);
				mongoTemplate.upsert(
						Query.query(Criteria.where("attr_id").is(attvObj.get("attr_id"))),
						update,
						AttrValue.class);
			}		
			
			System.out.println("attr_values:" + attrValues.toJSONString());
			
			/**
			 * 同步属性型号
			 */
			String attrTitle = modelAttr.getString("attr_title");
			Query query = Query.query(Criteria.where("attr_title").is(attrTitle));
			Update update = new Update();
			update.set("attr_title", attrTitle);
			update.set("attr_values", attrValues.toJavaList(AttrValue.class));
			mongoTemplate.upsert(query, update, ModelAttr.class);	
		}
		
		
		List<ModelAttr> mas =  mongoTemplate.findAll(ModelAttr.class);
		List<AttrValue> avs = mongoTemplate.findAll(AttrValue.class);
		System.out.println("mas:" + mas);
		System.out.println("avs:" + avs);
	}
	
	public void test(){
		MongoCollection collection = mongoTemplate.getCollection("aa");
		 collection.find(Filters.eq("address.city", "Wimborne")).first();
		collection.updateMany()
		/*String res = "";
		try {
			res = productService.vdianItemGetItemDetail(2761295251L);
		} catch (OpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);*/

	}

	
}
