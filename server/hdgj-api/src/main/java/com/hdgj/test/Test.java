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
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.codecs.BsonValueCodecProvider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;

import me.welkinbai.bsonmapper.BsonMapper;
import me.welkinbai.bsonmapper.DefaultBsonMapper;

public class Test {
	public static void main(String[] args) throws Exception {
		String json = "[{$project:{imgs:1,istop:1,status:1,item_desc:1,merchant_code:1,stock:1,price:1,update_time:1,item_name:1,fx_fee_rate:1,thumb_imgs:1,seller_id:1,add_time:1,sold:1,_class:1,B_fk:{$map:{input:{$map:{input:\"$cates\", 	                      in: { 	                           $arrayElemAt: [{$objectToArray: \"$$this\"}, 1] 	                      }, 	                  } 	             }, 	             in: \"$$this.v\"}},   	        }, 	        	    },  	     	    { 	   	 $lookup: { 		        from:\"cate\",  		        localField:\"B_fk\", 		        foreignField:\"_id\",  		        as:\"cate\" 	        }  	    },  	     	    { 	    	$unwind:{path:\"$cate\"} 	    }, 	     	    { 	    	$sort:{\"cate.sort_num\" : 1} 	   	} 	]";
		JSONArray jsonArray = JSONArray.parseArray(json);
		
		List<JSONObject> list = jsonArray.toJavaList(JSONObject.class);
		
		List l = new ArrayList();
		Map map = new HashMap();
		for(JSONObject jsonObject : list){
			map = jsonStrToMap(jsonObject.toJSONString());
			//System.out.println(map);
			l.add(map);
		}
		System.out.println(l);
	}

	public static Map jsonStrToMap(String jsonStr){
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		
		Map<String,Object> map = new HashMap<String,Object>();
        Set<Entry<String, Object>> set = jsonObject.entrySet();
        Iterator<Entry<String,Object>> ite = set.iterator();
        
        /**
         * 开始解析
         */
        out:
        while(ite.hasNext()){
        	
        	Entry<String,Object> entry = ite.next();
        	String key = entry.getKey();		//key
        	Object value = entry.getValue();	//value

        	/**
        	 *  根据Value不同的情况来分类处理
        	 */
        	
        	
        	if(value instanceof JSONObject){
        		BSONObject bson = new BasicDBObject(key, jsonStrToMap(value.toString()));
        		map.put(entry.getKey(), bson);
        		continue out;
        	}
        	
        	if(value instanceof JSONArray){
        		
        		/**
        		 * value : 数组里的所有JSON对象
        		 */
        		JSONArray jsonArray = (JSONArray) value;
        		BsonString arrayString = new BsonString(jsonArray.toJSONString());      		
        		//BsonArray bson = new BsonArray(list);
        		
        		map.put(entry.getKey(), arrayString);
        		//System.out.println(arrayString);
        		continue out;
        	}
        	
        	/**
        	 * 否则,如果不是数组，也不是JSON对象，则是基础数据类型
        	 */
        	//BSONObject bson = new BasicDBObject(key, value);
    		map.put(key,value);
        	
    		
        }
       // System.out.println(map);
		return map;
	}

	public static List aggregate(String jsonString){
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		List<JSONObject> list = jsonArray.toJavaList(JSONObject.class);
		
		List aggregateList = new ArrayList();
		
		Map map = new HashMap();
		for(JSONObject jsonObject : list){
			map = jsonStrToMap(jsonObject.toJSONString());
			aggregateList.add(map);
		}
		
		return aggregateList;
		
	} 
}
