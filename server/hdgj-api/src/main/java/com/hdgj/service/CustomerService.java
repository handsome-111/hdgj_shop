package com.hdgj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hdgj.entity.Customer;
import com.hdgj.mapper.CustomerMapper;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public Customer getCustomerByUsername(String username){
		QueryWrapper<Customer> query = new QueryWrapper<Customer>();
		query.eq("username", username);
		return customerMapper.selectOne(query);
	}
	
	public int registerCustomer(Customer customer){
		return customerMapper.insert(customer);
	}
}
