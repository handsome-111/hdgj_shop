package com.hdgj.other.vd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.ProductDetail;
import com.hdgj.other.vd.api.ProductService;
import com.hdgj.other.vd.service.SyncVdService;
import com.weidian.open.sdk.exception.OpenException;

/**
 * 同步微店调度器
 * @author Administrator
 *
 */
@Component
public class SyncVdScheduler {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SyncVdService syncVdService;
	
	/**
	 * 同步微店商品
	 * @throws OpenException 
	 */
	@Scheduled(initialDelayString = "${jobs.initialDelay}",fixedRateString="${jobs.fixedRate}")
	public void synVdProducts() throws OpenException,Exception{	
		//syncVdService.syncVdProduct();
		syncVdService.syncVdProductDetail();
		//syncVdService.test4();
		//syncVdService.test3();
		//syncVdService.syncSkuAttr();
		//syncVdService.test();
	}

}
