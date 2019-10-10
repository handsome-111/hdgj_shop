package com.hdgj.service;

import java.util.List;

import com.hdgj.entity.Cate;

public interface CateService {
	
	Cate save(Cate cate);
	Iterable<Cate> saveAll(List<Cate> cates);

}
