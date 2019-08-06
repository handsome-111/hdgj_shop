package com.hdgj.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.api.service.LoginService;

@RestController
public class HomeController {
	
	@Autowired
	private LoginService loginService;
	
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
	
	
	@RequestMapping("/wxLogin")
	public String wxLogin(@RequestParam String js_code){
		return loginService.wxLogin(js_code);
	}
}
