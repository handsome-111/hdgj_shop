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
		//获取类上的注解
		Annotation an = AnnotationUtils.findAnnotation(ShopProduct.class,Document.class);
		
		Field[] fields = ShopProduct.class.getDeclaredFields();
		
		for(Field field : fields){
			System.out.println(field.getName());
		}
		
		//AnnotatedElement element = AnnotationUtils
		//获取注解所有的属性
		Map<String,Object> attributes = AnnotationUtils.getAnnotationAttributes(an);
		System.out.println(attributes);
		
		
	}

}
