package com.hdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdgj.entity.Address;
import com.hdgj.entity.User;
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
@Transactional(value="db1TransactionManager")
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
	
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public List<Address> selectByUserid(String userid) {
		QueryWrapper query = new QueryWrapper();
		query.eq("userid", userid);
		return super.list(query);
	}

	/**
	 * 更新地址
	 * 1.如果带有旧地址,说明要将旧地址取消默认地址,将新地址设置为默认地址
	 * 2.没有旧地址说明直接更新或者插入新地址
	 */
	@Override
	public boolean updateAddress(Address address,int userId) {
		User user = new User();
		user.setId(userId);
		
		address.setUser(user);
		
		//如果没有设置默认地址
		if(address.getIsDefault() != 1){
			super.saveOrUpdate(address);
		}
		
		//如果设置了默认地址
		if(address.getIsDefault() == 1){
			addressMapper.cancelDefaultAddress(userId);
			super.saveOrUpdate(address);
		}
		return true;
	}

	@Override
	public Address findDefaultAddress(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
