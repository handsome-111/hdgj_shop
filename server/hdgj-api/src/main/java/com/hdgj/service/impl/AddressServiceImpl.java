package com.hdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdgj.entity.Address;
import com.hdgj.mapper.AddressMapper;
import com.hdgj.service.AddressService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-19
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
	
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public List<Address> selectByUserid(String userid) {
		QueryWrapper query = new QueryWrapper();
		query.eq("userid", userid);
		return super.list(query);
	}
	
	
	
}
