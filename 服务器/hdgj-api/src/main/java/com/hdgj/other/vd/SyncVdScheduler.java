package com.hdgj.other.vd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
	public void synVdProducts() throws OpenException{	
		String res = "";
		syncVdService.syncVdProductDetail();
		//syncVdService.test4();
		//syncVdService.test3();
		//syncVdService.syncSkuAttr();
		//syncVdService.test();
		System.out.println("ok" + res);
	}

}
