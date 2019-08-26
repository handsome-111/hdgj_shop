package com.hdgj.other.vd.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdgj.entity.ProductDetail;
import com.hdgj.entity.repository.ProductDetailRepository;

@Service
public class ProductDetailService{
	@Autowired
	private ProductDetailRepository productDetailRepository;
	
	/**
	 * 同步商品详情,删除并添加
	 */
	@Transactional
	public void delAndSave(String id,List<ProductDetail> resDetails){
		productDetailRepository.deleteByItemId(id);
		productDetailRepository.saveAll(resDetails); 
		
	}
	
}
