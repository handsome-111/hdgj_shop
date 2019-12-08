package com.hdgj.test;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.BasicBSONObject;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;

public class Test2 {
	public static BSONObject jsonToBson(JSONObject jsonObject){
        Set<Entry<String, Object>> set = jsonObject.entrySet();
        Iterator<Entry<String,Object>> ite = set.iterator();
        BSONObject bson = new BasicBSONObject();

        out:
        while(ite.hasNext()){
          Entry<String,Object> entry = ite.next();
          String key = entry.getKey();		//key
         Object value = entry.getValue();	        //value
         BSONObject bsonObject = new BasicDBObject(key,value);
         bson.putAll(bsonObject);
        }
        return bson;
	}
}
