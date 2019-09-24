package com.hdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/updateAddress")
	public ResponseData updateAddress(@RequestBody Address address){
		System.out.println(address.toString());
		return ResponseDataUtil.buildSuccess(address);
	}
	
	@PostMapping("/aaaa")
	public ResponseData updateAddresss(@RequestParam("address") String address){
		System.out.println(address.toString());
		return ResponseDataUtil.buildSuccess(address);
	}
	
	@GetMapping("/updateAddresss")
	public ResponseData updateAddress(){
		System.out.println("------------");
		return ResponseDataUtil.buildSuccess("111");
	}
}
