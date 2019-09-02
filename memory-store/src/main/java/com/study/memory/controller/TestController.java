package com.study.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/t1")
	public String t1(){
		String secret = "secret";
		String password = "123456";
		
		return passwordEncoder.encode(secret) + "," + passwordEncoder.encode(password) ;
	}
}
