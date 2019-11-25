package com.hdgj.test;



import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Map;

import org.joda.time.chrono.AssembledChronology.Fields;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hdgj.entity.ShopProduct;

public class Test {
	public static void main(String[] args) throws Exception {
		String json = "{ \"_id\" : \"2731676821\", \"cate\" : [{ \"_id\" : 130233853, \"cate_name\" : \"美国USANA子系列\\n葆婴/葆苾康系列\\n（会员可官网下单）\", \"sort_num\" : 150, \"cate_item_num\" : 9, \"listUrl\" : \"http://weidian.com/item_classes.html?userid=1287081375&c=130233853&des=%E7%BE%8E%E5%9B%BDUSANA%E5%AD%90%E7%B3%BB%E5%88%97%0A%E8%91%86%E5%A9%B4%2F%E8%91%86%E8%8B%BE%E5%BA%B7%E7%B3%BB%E5%88%97%0A%EF%BC%88%E4%BC%9A%E5%91%98%E5%8F%AF%E5%AE%98%E7%BD%91%E4%B8%8B%E5%8D%95%EF%BC%89\", \"shopLogo\" : \"https://si.geilicdn.com/weidian1287081375-255100000167cb0088680a217205_984_984.jpg?w=250&h=250&cp=1\", \"shopName\" : \"华典国际绿色商城\", \"description\" : \"向您推荐 美国USANA子系列\\n葆婴/葆苾康系列\\n（会员可官网下单）\", \"_class\" : \"com.hdgj.entity.Cate\" }] }";
		
		System.out.println(json);
		
		//获取类上的注解
		Annotation an = AnnotationUtils.findAnnotation(ShopProduct.class,Document.class);
		
		Field[] fields = ShopProduct.class.getDeclaredFields();
		
		
		
		for(Field field : fields){
			Annotation id = field.getAnnotation(Id.class);
			Annotation fieldAnnotation = field.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class);
			if(id != null){
				System.out.println("字段名称：" + field.getName() + "," + AnnotationUtils.getValue(id));
			}
			
			if(fieldAnnotation != null){
				System.out.println("字段名称：" + field.getName() + "," + AnnotationUtils.getValue(fieldAnnotation));
			}
			
			//System.out.println(field.getName());
		}
		
		//AnnotatedElement element = AnnotationUtils
		//获取注解所有的属性
		Map<String,Object> attributes = AnnotationUtils.getAnnotationAttributes(an);
		System.out.println(attributes);
		
		
	}

}
