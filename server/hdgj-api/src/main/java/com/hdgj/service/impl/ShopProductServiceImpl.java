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
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.redis.connection.convert.StringToDataTypeConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
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
		DBObject objectToArray =  new BasicDBObject("$objectToArray","$$this");
		List arrayElemAtList = new ArrayList();
		arrayElemAtList.add(objectToArray);
		arrayElemAtList.add(1);
		DBObject arrayElemAt = new BasicDBObject("$arrayElemAt",arrayElemAtList);
		
		//in2
		//DBObject in2 = new BasicDBObject("in",arrayElemAt);
		
		Map<Object,Object> map2 = new HashMap();
		map2.put("input", "$cates");
		map2.put("in", arrayElemAt);

		Map<Object,Object> input1 = new HashMap();
		input1.put("$map", map2);
		
		Map<Object,Object> map1 = new HashMap();
		map1.put("input", input1);
		map1.put("in","$$this.v");
		
		DBObject map = new BasicDBObject("$map",map1);
		
		Map<String,Object> project = new HashMap<String,Object>();
		project.put("B_fk",map);
		project.put("imgs", 1);
		project.put("istop", 1);
		project.put("status", 1);
		project.put("item_desc", 1);
		project.put("merchant_code", 1);
		project.put("stock", 1);
		project.put("price", 1);
		project.put("update_time", 1);
		project.put("item_name", 1);
		project.put("fx_fee_rate", 1);
		project.put("thumb_imgs", 1);
		project.put("seller_id", 1);
		project.put("add_time", 1);
		project.put("sold", 1);
		project.put("_class", 1);
		
		BSONObject aggProject=new BasicDBObject("$project", project);
		// imgs:1,istop:1,status:1,item_desc:1,merchant_code:1,stock:1,price:1,update_time:1,item_name:1,fx_fee_rate:1,thumb_imgs:1,seller_id:1,skus:1,add_time:1,sold:1,_class:1,
		
		
		
		/**
		 * look up
		 */
		Map lookupValue = new HashMap();
		lookupValue.put("from", "cate");
		lookupValue.put("localField", "B_fk");
		lookupValue.put("foreignField", "_id");
		lookupValue.put("as", "cate");

		BSONObject lookup = new BasicDBObject("$lookup",lookupValue);
		 
		BSONObject project2=new BasicDBObject("$project", new BasicDBObject("B_fk",0));

		
		/*String str = "db.shop_product.aggregate([{$project:{B_fk:{$map:{input:{$map:{input:\"$cates\",in:{$arrayElemAt:[{$objectToArray:\"$$this\"},1]},}},in:\"$$this.v\"}},}},{$lookup:{from:\"cate\",localField:\"B_fk\",foreignField:\"_id\",as:\"cate\"}}])";
		BasicDBObject bson = new BasicDBObject();
		bson.put("$eval", str);
		System.out.println("str:" + bson);
		Document document = mongoTemplate.getDb().runCommand(bson);*/
		
		List list = new ArrayList();
		list.add(aggProject);
		list.add(lookup);
		list.add(project2);
		
		System.out.println("list:" + list);
		AggregateIterable<Document> result = mongoTemplate.getCollection("shop_product").aggregate(list);
		MongoCursor<Document> m = result.iterator();
		StringToDataTypeConverter c = new StringToDataTypeConverter();
		Gson gson = new Gson();
		while(m.hasNext()){
			Document shop = m.next();
			String realJson = shop.toJson(JsonWriterSettings.builder().build());
			MappingMongoConverterParser mm = new MappingMongoConverterParser();

			System.out.println("shop:" + realJson);
		}
		
		BasicDBObject bson2 = new BasicDBObject();
		bson2.put("$eval", "db.aa.insertOne({aa:1211})");
		//Document document = mongoTemplate.getDb().runCommand(bson2);
		
		//System.out.println("结果集：" + document.toJson());
		return null;
	}
	
	

}




