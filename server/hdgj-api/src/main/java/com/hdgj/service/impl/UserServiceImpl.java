package com.hdgj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdgj.entity.Customer;
import com.hdgj.entity.User;
import com.hdgj.mapper.UserMapper;
import com.hdgj.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService,UserDetailsService{
	
	@Autowired
	private UserMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		return super.save(user);
	}

	@Override
	public User findByOpenid(String openid) {
		/*QueryWrapper query = new QueryWrapper();
		query.eq("openid", openid);
		return super.getOne(query);*/
		User user = mapper.selectUserByopenid(openid);
		return user;
	}

	@Override
	public User selectUserByopenid(String openid) {
		User user = mapper.selectUserByopenid(openid);
		return user;
	}

}




