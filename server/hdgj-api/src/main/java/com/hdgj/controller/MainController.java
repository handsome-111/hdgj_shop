package com.hdgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hdgj.service.LoginService;
import com.hdgj.utils.ResponseData;

@RestController
public class MainController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private String vdToken;
	
	
	@RequestMapping("/")
	public String index(){
		return "首页" + vdToken ;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView("/login.html");
		return mav;
	}
	
	/*@Autowired 
	private CustomerService customerService;*/
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * 127.0.0.1/userPasswordRegister?username=bbb&password=123456
	 * @param username
	 * @param password
	 * @return
	 */
	/*@RequestMapping("/userPasswordRegister")
	public String userPasswordRegister(@RequestParam("username") String username,@RequestParam("password")String password){
		Customer customer = customerService.getCustomerByUsername(username);
		if(customer != null){
			return "用户名已存在";
		}
		customer = new Customer();
		customer.setUsername(username);
		customer.setPassword(passwordEncoder.encode(password));
		customer.setRoles("USER");
		customerService.registerCustomer(customer);
		return "注册成功";
	}*/
	
	/**
	 * 微信登陆
	 * @param js_code
	 * @param userInfo	User
	 * @return
	 */
	@RequestMapping("/wxLogin")
	public String wxLogin(@RequestParam String js_code,@RequestParam("userinfo") String userInfo){
		System.out.println("jsonObject:" + userInfo);
		return loginService.wxLogin(js_code,userInfo);
	}
	
	/**
	 * 微信注销
	 * @return
	 */
	@RequestMapping("/wxLogout")
	public ResponseData wxLogout(@RequestParam String session_key){
		System.out.println(session_key);
		return loginService.wxLogout(session_key);
	}
}
