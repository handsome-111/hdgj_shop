package com.hdgj.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.entity.Address;
import com.hdgj.entity.User;
import com.hdgj.mongoparse.MongoParsehandler;
import com.hdgj.service.AddressService;
import com.hdgj.service.UserService;


@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private MongoParsehandler parser;
	
	@RequestMapping("/test1")
	public String test1(){
		User user = userService.selectUserByopenid("oFyDr4m6n1FwFUZJBwNztItuERfE");
		System.out.println(user);
		System.out.println(user.getRoles());
		return user.toString();
	}
	
	@RequestMapping("/test2")
	public String test2(){
		List<Address> addresses = addressService.selectByUserid("11");
		return addresses.toString();
	}
	
	@RequestMapping("/test3")
	public String test3() throws FileNotFoundException{
		String classpath = ResourceUtils.getURL("classpath:").getPath();	//直接使用即可
		return null;
	}
}
