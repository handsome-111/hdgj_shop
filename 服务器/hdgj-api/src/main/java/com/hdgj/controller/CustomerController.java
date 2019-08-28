package com.hdgj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@RequestMapping("/c")
	public String t(){
		/*QueryWrapper query = new QueryWrapper();
		query.eq("username", "123465");
		Customer customer = customerMapper.selectOne(query);*/
		customerMapper.getCustomerAll();
		return "goood";
	}
}

