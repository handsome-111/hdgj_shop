package com.hdgj.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hdgj.service.CustomerService;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerService customerService;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerService.getCustomerByUsername(username);
	}
	

}
