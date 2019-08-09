package com.hdgj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdgj.entity.WxEntity;

@RequestMapping("/test")
@Controller
public class TestController {
	
	@RequestMapping("/t1")
	public ResponseEntity<WxEntity> test1(){
		WxEntity w = new WxEntity();
		w.setId("asdasd");
		w.setName("哈哈");
		return new ResponseEntity<WxEntity>(w,HttpStatus.OK);
	}
}
