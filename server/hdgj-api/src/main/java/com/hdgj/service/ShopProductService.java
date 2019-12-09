package com.hdgj.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.hdgj.entity.ShopProduct;

public interface ShopProductService {
	//public List<ShopProduct>  getShopProductsOrderBySoldDesc(int page,int size);
	public List<String> getIdsOrderBySoldDesc(int page,int size);
	void delAndSaveAll(List<String> ids,List<ShopProduct> shopProducts);
	void saveAll(List<ShopProduct> shopProducts);
	void deleteAll(List<String> ids);
	
	JSONArray sortShopProductList(int page,int size);
}
