package com.hdgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hdgj.service.LoginService;

@RestController
public class MainController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private String vdToken;
	
	
	@RequestMapping("/")
	public String index(){
		return "首页" + vdToken ;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView("/login.html");
		return mav;
	}
	
	
	@RequestMapping("/wxLogin")
	public String wxLogin(@RequestParam String js_code){
		return loginService.wxLogin(js_code);
	}
}
