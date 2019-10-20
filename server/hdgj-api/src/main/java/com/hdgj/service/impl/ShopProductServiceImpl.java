package com.hdgj.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.ShopProduct;
import com.hdgj.entity.repository.ShopProductRepository;
import com.hdgj.service.ShopProductService;

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
		Page<ShopProduct> p = shopProductRespository.findAll(PageRequest.of(page, size,Sort.by(Direction.DESC, "sold")));
		return p.getContent();
	}

}
