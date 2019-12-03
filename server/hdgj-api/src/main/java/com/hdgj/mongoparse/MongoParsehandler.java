package com.hdgj.mongoparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class MongoParsehandler{
	private Map<String,String> xmlPath = new HashMap<String,String>();
	private Map<String,Map> documents = new HashMap<String,Map>();
	
	public MongoParsehandler(@Value("${mongopath}")String mongopath) throws FileNotFoundException{
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
				String suffix = fileName[1];
				xmlPath.put(prefix, suffix);
			}		
		}
	}
	
	public void loadXMLFile(){
		//ResourceUtils.getFile("");
	}
	
	public void init() throws DocumentException{
		//创建解析器
		SAXReader sax=new SAXReader();
		
		Set<String> keys = xmlPath.keySet();
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
		}
		
		//通过解析器的read方法将配置文件读取到内存中，生成一个document对象树
		Document document=sax.read("src/Student.xml");
		//获取了根节点
		Element element=document.getRootElement();
		//遍历根节点
		Iterator<Element> ite = element.elementIterator();
		while(ite.hasNext()){
			//获得子节点后继续遍历子节点
			Element e=ite.next();
			Iterator<Element> eite=e.elementIterator();
			while(eite.hasNext()){
				Element el=(Element) eite.next();
				System.out.println(el.getName()+":"+el.getStringValue());
			}
		}
	}
}
