package com.hdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.Address;
import com.hdgj.entity.User;
import com.hdgj.service.AddressService;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/getUserAddresses")
	public ResponseData getUserAddresses(@RequestParam String userid){
		List<Address> addresses = addressService.selectByUserid(userid);
		Address address = addresses.get(0);
		User user = address.getUser();
		return ResponseDataUtil.buildSuccess(addresses);
	}
	
	@PostMapping("/updateAddress")
	public ResponseData updateAddress(@RequestBody JSONObject jsonObject){
		Address address = jsonObject.getJSONObject("requestParam").getJSONObject("address").toJavaObject(Address.class);
		Integer userId = jsonObject.getJSONObject("requestParam").getInteger("userId");
		
		System.out.println("请求：" + jsonObject);
		
		System.out.println(addressService.updateAddress(address,userId));
		return ResponseDataUtil.buildSuccess(address);
	}
	
	@GetMapping("/deleteAddress")
	public ResponseData deleteAddress(@RequestParam("id") Integer id){
		int status = 0;
		if(addressService.removeById(id)){
			status = 1;
		}
		return ResponseDataUtil.buildSuccess(status);
	}
}
