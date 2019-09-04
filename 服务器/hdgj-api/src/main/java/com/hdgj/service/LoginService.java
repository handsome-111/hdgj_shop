package com.hdgj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.User;

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
	
	@Autowired
	private StringRedisTemplate redis;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
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
		System.out.println("redis:" + redis + "redisTemplate:" + redisTemplate);
		/**
		 * 获取响应信息,并转换成JSON对象
		 * response:{"openid":"oFyDr4m6n1FwFUZJBwNztItuERfE","session_key":"1gBBoh1y9V4iUDZEoSKh0g=="}
		 */
		String res = restTemplate.getForObject(uri.toString(), String.class);
		JSONObject resObject = JSONObject.parseObject(res);
		
		String sessionKey = resObject.getString("session_key");
		String openid = resObject.getString("openid");
		
		/**
		 * 请求失败,直接返回
		 */
		if(sessionKey == null){
			return null;
		}
		
		/**
		 * 向数据库查询用户信息,并缓存
		 * 成功响应,直接缓存会话信息
		 */
		User user = new User();
		user.setPassword("123456");
		user.setUsername("amazingJ");
		user.setPhone("123465789");
		user.setOpenid(openid);
		
		/**
		 * 缓存用户的会话
		 */
		Map<String,Object> userSession = new HashMap<String,Object>();
		userSession.put("user",user);
		userSession.put("sessionKey",sessionKey);		//存储sessionKey
		
		/**
		 * 缓存微信会话,如果二次登陆会直接覆盖掉原来的会话的
		 */
		redisTemplate.opsForHash().put("wx_session_key", openid , userSession);					
		
		System.out.println("response:" + resObject);
		return "登陆成功";
	}
	
	
	
}






