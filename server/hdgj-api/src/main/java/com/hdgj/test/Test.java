package com.hdgj.test;



import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.bson.BSONObject;
import org.joda.time.chrono.AssembledChronology.Fields;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.ShopProduct;
import com.mongodb.BasicDBObject;

public class Test {
	public static void main(String[] args) throws Exception {
		String json = "[{$project:{imgs:1,istop:1,status:1,item_desc:1,merchant_code:1,stock:1,price:1,update_time:1,item_name:1,fx_fee_rate:1,thumb_imgs:1,seller_id:1,add_time:1,sold:1,_class:1,B_fk:{$map:{input:{$map:{input:\"$cates\", 	                      in: { 	                           $arrayElemAt: [{$objectToArray: \"$$this\"}, 1] 	                      }, 	                  } 	             }, 	             in: \"$$this.v\"}},   	        }, 	        	    },  	     	    { 	   	 $lookup: { 		        from:\"cate\",  		        localField:\"B_fk\", 		        foreignField:\"_id\",  		        as:\"cate\" 	        }  	    },  	     	    { 	    	$unwind:{path:\"$cate\"} 	    }, 	     	    { 	    	$sort:{\"cate.sort_num\" : 1} 	   	} 	]";
		JSONArray jsonArray = JSONArray.parseArray(json);
		
		List<JSONObject> list = jsonArray.toJavaList(JSONObject.class);
		Map map = new HashMap();
		for(JSONObject jsonObject : list){
			map = jsonStrToMap(jsonObject.toJSONString());
			System.out.println(map);

		}
			
	}
	
	public static Map jsonStrToMap(String jsonStr){
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		
		Map<String,Object> map = new HashMap<String,Object>();
        Set<Entry<String, Object>> set = jsonObject.entrySet();
        Iterator<Entry<String,Object>> ite = set.iterator();
        while(ite.hasNext()){
        	
        	Entry<String,Object> entry = ite.next();
        	Object value = entry.getValue();
        	String key = entry.getKey();
        	
        	
        	//System.out.println(entry.getKey() + "," + entry.getValue());
        	
        	try {
            	String valueStr = ((JSONObject)entry.getValue()).toJSONString();
            	BSONObject bson = new BasicDBObject(key, jsonStrToMap(valueStr));
        		map.put(entry.getKey(), bson);
        		
			} catch (Exception e) {
				
				BSONObject bson = new BasicDBObject(key, value);
        		map.put(entry.getKey(), bson);
			}
        	
        	/*if (value.startsWith("{") && value.endsWith("}")) {
        		
        		BSONObject bson = new BasicDBObject(key, jsonStrToMap(value));
        		map.put(entry.getKey(), bson);
        		
            } else {
            	
            	BSONObject bson = new BasicDBObject(key, value);
        		map.put(entry.getKey(), bson);
            }*/
        }
       // System.out.println(map);
		return map;
	}

}
