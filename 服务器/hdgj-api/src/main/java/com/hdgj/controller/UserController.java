package com.hdgj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUserInfo")
	public String getUserInfo(){
		return "这里是用户信息";
	}
}
