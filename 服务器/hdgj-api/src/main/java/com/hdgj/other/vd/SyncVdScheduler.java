package com.hdgj.other.vd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hdgj.other.vd.api.ProductService;
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
	
	/**
	 * 同步微店商品
	 */
	@Scheduled(initialDelayString = "${jobs.initialDelay}",fixedRateString="${jobs.fixedRate}")
	public void synVdProducts(){
		System.out.println("要启动咯");
		try {
			String response = productService.vdianItemListGet(1, 0, 0, null, 0, null);
			System.out.println(response);

		} catch (OpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
