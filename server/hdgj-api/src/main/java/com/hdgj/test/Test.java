package com.hdgj.test;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.Product;

public class Test {
	public static void main(String[] args) throws Exception {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		System.out.println(mem.getUsed());
		Product p = new Product();
		p.setId("23134465");
		String str = "打死和扩大的全额委屈签到权威的 打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的打死和扩大的全额委屈签到权威的";
		System.out.println(mem.getUsed());
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
