package com.hdgj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.config.MappingMongoConverterParser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.redis.connection.convert.StringToDataTypeConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hdgj.entity.ShopProduct;
import com.hdgj.entity.repository.ShopProductRepository;
import com.hdgj.mongoparse.MongoParsehandler;
import com.hdgj.service.ShopProductService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;

@Service
public class ShopProductServiceImpl implements ShopProductService {
	@Autowired
	private ShopProductRepository shopProductRespository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private MongoParsehandler mongoParsehandler;
	
	/*@Override
	public List<ShopProduct> getShopProductsOrderBySoldDesc(int page,int size) {
		return shopProductRespository.getAllBy(PageRequest.of(page, size,Sort.by(Direction.DESC, "sold")));
	}*/



	@Override
	public List<String> getIdsOrderBySoldDesc(int page, int size) {
		List<JSONObject> result = shopProductRespository.findAllBy(PageRequest.of(page, size,Sort.by(Direction.DESC, "sold")));
		List<String> ids = new LinkedList<String>();
		for(int i = 0;i < result.size(); i++){
			ids.add(result.remove(i).getString("_id"));
		}
		return ids;
	}

	@Override
	@Transactional(transactionManager="mongoTransactionManager")
	public void delAndSaveAll(List<String> ids, List<ShopProduct> shopProducts) {
		List<ShopProduct> delShopProducts = new LinkedList<ShopProduct>();
		
		ShopProduct sp = null;
		for(String id : ids){
			sp = new ShopProduct();
			sp.setItemid(id);
			delShopProducts.add(sp);
		}
		shopProductRespository.deleteAll(delShopProducts); 
		shopProductRespository.saveAll(shopProducts);
	}

	@Override
	public void saveAll(List<ShopProduct> shopProducts) {	
		shopProductRespository.saveAll(shopProducts);
	}

	@Override
	public void deleteAll(List<String> ids) {
		List<ShopProduct> delShopProducts = new LinkedList<ShopProduct>();
		
		ShopProduct sp = null;
		for(String id : ids){
			sp = new ShopProduct();
			sp.setItemid(id);
			delShopProducts.add(sp);
		}
		shopProductRespository.deleteAll(delShopProducts); 		
	}

	@Override
	public JSONArray sortShopProductList(int page, int size) {
		List list = mongoParsehandler.aggregate.get("sortShopProductList");
		AggregateIterable<Document> result = mongoTemplate.getCollection("shop_product").aggregate(list);

		MongoCursor<Document> m = result.iterator();
		JSONArray jsonArray = new JSONArray();
		while(m.hasNext()){
			Document shop = m.next();
			String realJson = shop.toJson(JsonWriterSettings.builder().build());
			jsonArray.add(realJson);
		}
	
		return jsonArray;
	}
	
	

}




