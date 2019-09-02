package com.hdgj.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/test")
@Controller
@EnableOAuth2Sso
public class TestController {
	
	@RequestMapping("/test1")
	public String test1(){
		return "hello world";
	}
}
