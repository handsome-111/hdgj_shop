package com.hdgj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.ShopProduct;
import com.hdgj.entity.repository.ShopProductRepository;
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
	public List<ShopProduct> getAll(int page, int size) {
		//Page<ShopProduct> p = shopProductRespository.findAll(PageRequest.of(page, size,Sort.by(Direction.DESC, "sold")));
		/*Aggregation agg = Aggregation.newAggregation(
				Aggregation.unwind("cates")
				//Aggregation.project().andExpression("").m.as("B_fk"),
				//Aggregation.lookup("cate", "cates", "_id", "cates")
				);*/
		Criteria criteria = new Criteria();
		
		DBObject input2 = new BasicDBObject("input","$cates");
		
		/**
		 *  $arrayElemAt
		 */
		DBObject objectToArray =  new BasicDBObject("objectToArray","$$this");
		List arrayElemAtList = new ArrayList();
		arrayElemAtList.add(objectToArray);
		arrayElemAtList.add(1);
		DBObject arrayElemAt = new BasicDBObject("arrayElemAt",arrayElemAtList);
		
		//in2
		//DBObject in2 = new BasicDBObject("in",arrayElemAt);
		
		Map<Object,Object> map2 = new HashMap();
		map2.put("input", "$cates");
		map2.put("in", arrayElemAt);

		
		Map<Object,Object> map1 = new HashMap();
		map1.put("input", map2);
		map1.put("in","$$this.v");
		
		DBObject map = new BasicDBObject("$map",map1);
		
		DBObject project=new BasicDBObject("$project", new BasicDBObject("B_fk",map));
				
		List<? extends Bson> list = (List<? extends Bson>) new ArrayList<DBObject>();
		//list.add(project);
		
		String str = "db.shop_product.aggregate([{$project:{B_fk:{$map:{input:{$map:{input:\"$cates\",in:{$arrayElemAt:[{$objectToArray:\"$$this\"},1]},}},in:\"$$this.v\"}},}},{$lookup:{from:\"cate\",localField:\"B_fk\",foreignField:\"_id\",as:\"cate\"}}])";
		BasicDBObject bson = new BasicDBObject();
		bson.put("$eval", str);
		System.out.println("str:" + bson);
		//Document document = mongoTemplate.getDb().runCommand(bson);
		
		BasicDBObject bson2 = new BasicDBObject();
		bson2.put("$eval", "db.aa.insertOne({aa:99})");
		Document document = mongoTemplate.getDb().runCommand(bson2);
		
		System.out.println(document.toJson());
		return null;
	}
	
	

}




