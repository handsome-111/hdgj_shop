package com.hdgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.entity.User;
import com.hdgj.service.UserService;


@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/test1")
	public String test1(){
		System.out.println("----------------------------");
		User user = userService.findByOpenid("oFyDr4m6n1FwFUZJBwNztItuERfE");
		System.out.println("address:" + user.getDefaultAddress());
		System.out.println("user:"  + user);
		return user.toString();
	}
}
