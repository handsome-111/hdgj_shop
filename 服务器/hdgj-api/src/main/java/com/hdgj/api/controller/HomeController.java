package com.hdgj.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weidian.open.sdk.request.product.VdianItemGetRequest;

@RestController
public class HomeController {
	

	@Autowired
	private String vdToken;
	
	
	@RequestMapping("/")
	public String index(){
		return "首页" + vdToken ;
	}
	
	@RequestMapping("/login")
	public String login(){
		return "登录页面";
	}
}
