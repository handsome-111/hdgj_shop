package com.hdgj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hdgj.entity.Customer;
import com.hdgj.mapper.CustomerMapper;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Mr.hj
 * @since 2019-08-28
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerMapper customerMapper;
		
	@RequestMapping("/c")
	public String t(){
		QueryWrapper query = new QueryWrapper();
		query.eq("username", "aaa");
		Customer customer = customerMapper.selectOne(query);
		Customer cus = customerMapper.selectOne(query);	
		System.out.println(cus);
		System.out.println(cus.getAuthorities());
		return "goood";

	}
}

