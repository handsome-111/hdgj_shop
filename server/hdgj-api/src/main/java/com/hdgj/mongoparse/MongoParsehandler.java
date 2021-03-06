package com.hdgj.mongoparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.BsonString;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;

import io.netty.handler.codec.http.multipart.Attribute;

@Component
public class MongoParsehandler{
	private Map<String,File> xmlPath = new HashMap<String,File>();
	private Map<String,Map> documents = new HashMap<String,Map>();
	
	public static Map<String,List> aggregate =  new HashMap<String,List>();
	
	private MongoTemplate mongoTemplate;
	
	public MongoParsehandler(@Value("${mongopath}")String mongopath,
			@Autowired MongoTemplate mongoTemplate) {
		
		this.mongoTemplate = mongoTemplate;
		
		try {
			init(mongopath);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public void init(String mongopath)throws Exception{
		String[] temp = mongopath.split("/");		//mongoMapper/*.xml
		mongopath = temp[0];						//mongoMapper
		
		String classpath = null;
		try {
			classpath = ResourceUtils.getURL("classpath:").getPath();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		mongopath = classpath + mongopath;
		File[] files = ResourceUtils.getFile(mongopath).listFiles();
		for(File file : files){
			String[] fileName = file.getName().split("\\.");
			
			if(fileName.length > 0){
				String prefix = fileName[0];
				xmlPath.put(prefix, file);
			}		
		}
		
		init();
	}
	
	public void init() throws DocumentException{
		Set<String> keys = xmlPath.keySet();
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			this.loadXMLFile(xmlPath.get(key));
		}	
	}
	
	public void loadXMLFile(File file) throws DocumentException{
		//ResourceUtils.getFile("");
		//创建解析器
		SAXReader sax=new SAXReader();
		//通过解析器的read方法将配置文件读取到内存中，生成一个document对象树
		Document document=sax.read(file);
		//获取了根节点
		Element element=document.getRootElement();
		//遍历根节点
		Iterator<Element> ite = element.elementIterator();
		while(ite.hasNext()){
			//获得子节点后继续遍历子节点
			Element e=ite.next();
			//aggregate(e.getStringValue());
			String key = e.attributeValue("id");
			String value = e.getStringValue();
			aggregate.put(key, aggregate(value));
		}
	}

	
	public static List<BSONObject> aggregate(String jsonString){
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		List<JSONObject> list = jsonArray.toJavaList(JSONObject.class);
		
		List<BSONObject> aggregateList = new ArrayList<BSONObject>();
		
		//Map map = new HashMap();
		for(JSONObject jsonObject : list){
			BSONObject bsonObject = jsonToBson(jsonObject);
			aggregateList.add(bsonObject);
		}
		
		
		
		return aggregateList;
		
	} 

	public static BSONObject jsonToBson(JSONObject jsonObject){
		Set<Entry<String, Object>> set = jsonObject.entrySet();
        Iterator<Entry<String,Object>> ite = set.iterator();
		BSONObject bson = new BasicDBObject();

        out:
        while(ite.hasNext()){
        	Entry<String,Object> entry = ite.next();
        	String key = entry.getKey();		//key
        	Object value = entry.getValue();	//value
  			BSONObject bsonObject = new BasicDBObject(key,value);
			bson.putAll(bsonObject);
        }
 		return bson;
	}
	

	
}
