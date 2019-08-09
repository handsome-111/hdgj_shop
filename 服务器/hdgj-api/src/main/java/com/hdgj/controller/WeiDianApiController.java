package com.hdgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weidian/api")
public class WeiDianApiController {		
	
	@Autowired
	private String vdAccessToken;

	
	@RequestMapping("/t")
	public String t() throws Exception {
		return "111";
	}
	
}
