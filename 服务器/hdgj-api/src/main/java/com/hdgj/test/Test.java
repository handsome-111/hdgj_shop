package com.hdgj.test;

import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args) {
		String str = "{\"a\":\"b\",\"openid\":\"oFyDr4m6n1FwFUZJBwNztItuERfE\"}";
		JSONObject js = (JSONObject) JSONObject.parseObject(str);
		System.out.println(js.get("aaa"));
	}
}
