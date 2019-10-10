package com.hdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hdgj.entity.ShopProduct;
import com.hdgj.entity.repository.ShopProductRepository;
import com.hdgj.service.ShopProductService;

@Service
public class ShopProductServiceImpl implements ShopProductService {
	@Autowired
	private ShopProductRepository shopProductRespository;
	
	@Override
	public List<ShopProduct> getShopProducts() {
		shopProductRespository.findAll(PageRequest.of(0,10));
		return null;
	}

}
