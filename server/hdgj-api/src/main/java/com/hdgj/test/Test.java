package com.hdgj.test;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.codecs.BsonValueCodecProvider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;


public class Test {
	public static void main(String[] args) throws Exception {
		int[] a = {2,1,9,2};
		System.out.println(sum(a));
	}
	
	public static int sum(int[] arr){
		return sum(arr,0);
	}
	
	public static int sum(int[] arr,int i){
		//基线条件
		if( i == arr.length ) {
			return 0;
		}
		
		//递归条件
		return arr[i] + sum(arr,i+1);
	}
}
