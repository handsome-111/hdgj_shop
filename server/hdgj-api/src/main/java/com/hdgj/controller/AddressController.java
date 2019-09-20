package com.hdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdgj.entity.Address;
import com.hdgj.service.AddressService;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/getUserAddresses")
	public ResponseData getUserAddresses(@RequestParam String userid){
		List<Address> addresses = addressService.selectByUserid(userid);
		return ResponseDataUtil.buildSuccess(addresses);
	}
}
