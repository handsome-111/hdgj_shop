package com.hdgj.test;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.Product;

public class Test {
	public static void main(String[] args) {
		Product p = new Product();
		p.setId("23134465");

		aa(p);
		System.out.println(p);
		bb(p);
		System.out.println(p);
	}
	public static void aa(Object obj){
		JSONObject j = (JSONObject) JSONObject.toJSON(obj);
		j.remove("id");
	}
	
	public static void bb(Object p){
		Product pp = (Product) p;
		pp.setId("1");
	}
}
