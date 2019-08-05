package com.hdgj.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Value("${weidian.appkey}")
	private String appkey;
	
	@RequestMapping("/")
	public String index(){
		return "首页" + appkey;
	}
	
	@RequestMapping("/login")
	public String login(){
		return "登录页面";
	}
}
