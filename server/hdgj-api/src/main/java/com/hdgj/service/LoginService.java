package com.hdgj.service;

import com.hdgj.utils.ResponseData;

public interface LoginService {
	/**
	 * 微信登陆
	 * @param jsCode
	 * @return
	 */
	String wxLogin(String jsCode,String userInfo);
	
	/**
	 * 微信注销
	 */
	ResponseData wxLogout(String session_key);
}






