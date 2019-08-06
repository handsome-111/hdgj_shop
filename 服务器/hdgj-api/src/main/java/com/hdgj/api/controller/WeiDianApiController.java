package com.hdgj.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.api.service.WeiDianService;

@RestController
@RequestMapping("/weidian/api")
public class WeiDianApiController {		
	
	@Autowired
	private String vdAccessToken;
	
	@Autowired
	private WeiDianService wdService;
	
	@RequestMapping("/t")
	public String t() throws Exception {
		return wdService.vdianItemListGet(1, 0, 30, null, 0,null);
	}
	
}
