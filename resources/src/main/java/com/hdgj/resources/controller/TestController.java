package com.hdgj.resources.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/view/t1")
	public String t1(){
		return "t1";
	}
	
	@RequestMapping("/t2")
	public String t2(){
		return "t2";
	}
}
