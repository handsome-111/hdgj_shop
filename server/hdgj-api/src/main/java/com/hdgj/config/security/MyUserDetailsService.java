package com.hdgj.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hdgj.entity.Customer;
import com.hdgj.entity.User;
import com.hdgj.service.UserService;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserService  userService;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByOpenid(username);
		return user;
	}
	

}
