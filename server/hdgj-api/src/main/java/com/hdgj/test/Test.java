package com.hdgj.test;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.Product;

public class Test {
	public static void main(String[] args) throws Exception {
		
	}
	public static void aa(int a){
		System.out.println("a:" + a);
	}
		
		public static void bb(Object p){
		Product pp = (Product) p;
		pp.setId("1");
	}
}
