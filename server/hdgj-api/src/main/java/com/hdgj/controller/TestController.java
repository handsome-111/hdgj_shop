package com.hdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.entity.Address;
import com.hdgj.service.AddressService;
import com.hdgj.service.UserService;


@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping("/test1")
	public String test1(){
		List<Address> addresses = addressService.selectByUserid("2");
		System.out.println(addresses);
		return addresses.toString();
	}
}
