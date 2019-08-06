package com.hdgj.api.service;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
	
	@Value("${wx.appid}")
	private String wxAppid;
	
	@Value("${wx.secret}")
	private String wxSecret;
	
	@Value("${wx.grant_type}")
	private String wxGrant_type;
	
	@Autowired
	private RestTemplate restTemplate;
	/**
	 * 微信登陆
	 * @return
	 */
	public String wxLogin(String jsCode){
		URIBuilder uri = new URIBuilder(); 
		uri.addParameter("grant_type", wxGrant_type);
		uri.addParameter("appid",wxAppid);
		uri.addParameter("secret",wxSecret);
		uri.addParameter("js_code", jsCode);
		
		uri.setHost("api.weixin.qq.com");					//设置主机
		uri.setPath("/sns/jscode2session");					//设置path
		uri.setScheme("https");		
		
		System.out.println(uri.toString());
		String response = restTemplate.getForObject(uri.toString(), String.class);
		return response;
	}
}






