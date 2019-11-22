package com.hdgj.mongo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hdgj.entity.ShopProduct;

public class ShopProductReadConverter implements Converter<Document, ShopProduct>{

	@Override
	public ShopProduct convert(Document arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
