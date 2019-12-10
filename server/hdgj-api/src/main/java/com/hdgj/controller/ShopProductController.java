package com.hdgj.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hdgj.service.ShopProductService;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@RestController
@RequestMapping(value="/shopProduct")
public class ShopProductController {
	
	@Autowired
	private ShopProductService shopProductService;
	
	@RequestMapping("/getShopProducts")
	public ResponseData getShopProducts(@RequestParam("page") int page,@RequestParam("size") int size){
		JSONArray data = shopProductService.sortShopProductList(page, size);
		System.out.println(data.toJSONString());
		
		Iterator<Object> ite = data.listIterator();
		
		JSONObject  group = new JSONObject();		//分组
		JSONObject result = new JSONObject();		//每一组
		String key = null;
		while(ite.hasNext()){
			String value = (String) ite.next();
			JSONObject jsonObject = JSONObject.parseObject(value);
			
			JSONObject cate = (JSONObject) jsonObject.remove("cate"); 
			key = ((Integer)cate.get("_id")).toString();
			
			cate.put("shopProducts", value);
			
			//每一组的集合
			JSONObject oneGroup = (JSONObject) group.get(key);
			if(oneGroup == null){				//如果未分组
				oneGroup = new JSONObject();
				
				/**
				 * 一组
				 */
				JSONArray oneGroupList = oneGroup.getJSONArray("shopProducts");
				if(oneGroupList == null){
					oneGroupList = new JSONArray();
					oneGroupList.add(jsonObject);
				}else{
					oneGroupList.add(jsonObject);
				}
				
				oneGroup.put("shopProducts", oneGroupList);
			}else{							//如果已分组
				JSONArray oneGroupList = oneGroup.getJSONArray("shopProducts");
				
				if(oneGroupList == null){
					oneGroupList = new JSONArray();
					oneGroupList.add(jsonObject);
				}else{
					oneGroupList.add(jsonObject);
				}
				oneGroup.put("shopProducts", oneGroupList);
			}
			
			group.put((String)key, oneGroup);

		}
		System.out.println(group);
		System.out.println(group.size());
		return ResponseDataUtil.buildSuccess(group);
	}
}
