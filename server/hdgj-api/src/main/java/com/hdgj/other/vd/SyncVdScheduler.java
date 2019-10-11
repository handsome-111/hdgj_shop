package com.hdgj.other.vd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hdgj.other.vd.api.VDService;
import com.hdgj.other.vd.service.SyncVdService;
import com.mongodb.ClientSessionOptions;
import com.mongodb.MongoClient;
import com.mongodb.session.ClientSession;
import com.weidian.open.sdk.exception.OpenException;

/**
 * 同步微店调度器
 * @author Administrator
 *
 */
@Component
public class SyncVdScheduler {

	@Autowired
	private VDService productService;
	
	@Autowired
	private SyncVdService syncVdService;
	
	@Autowired
	private MongoClient client;
	
	private MongoTemplate template;
	
	/**
	 * 同步微店商品
	 * @throws OpenException 
	 */
	@Scheduled(initialDelayString = "${jobs.initialDelay}",fixedRateString="${jobs.fixedRate}")
	public void synVdProducts() throws OpenException,Exception{	
		System.out.println("开始任务");
		/*System.out.println("1aaaaaaaaaaaaa");
		ClientSessionOptions sessionOptions = ClientSessionOptions.builder()
			    .causallyConsistent(true)
			    .build();

			ClientSession session = client.startSession(sessionOptions);
			System.out.println(session);*/
		syncVdService.syncCates();
		/*syncVdService.syncVdProduct();
		syncVdService.syncVdProductDetail();
		syncVdService.syncVdSkuAttr();*/

		//syncVdService.test4();
		//syncVdService.test3();
		//syncVdService.test();
	}

}
