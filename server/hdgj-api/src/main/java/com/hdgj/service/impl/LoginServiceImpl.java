package com.hdgj.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.User;
import com.hdgj.service.LoginService;
import com.hdgj.service.UserService;
import com.hdgj.utils.ResponseData;
import com.hdgj.utils.ResponseDataUtil;

@Service
public class LoginServiceImpl implements LoginService{
	
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
	
	@Autowired
	private UserService userService;
	
	
	
	/**
	 * 微信登陆
	 * @return
	 */
	public String wxLogin(String jsCode,String userInfo){
		URIBuilder uri = new URIBuilder(); 
		uri.addParameter("grant_type", wxGrant_type);
		uri.addParameter("appid",wxAppid);
		uri.addParameter("secret",wxSecret);
		uri.addParameter("js_code", jsCode);
		
		uri.setHost("api.weixin.qq.com");					//设置主机
		uri.setPath("/sns/jscode2session");					//设置path
		uri.setScheme("https");		
		
		System.out.println(uri.toString());
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
		 * 向数据库查询用户信息,存在则取出,不存在则注册
		 */
		User user = userService.findByOpenid(openid);
		System.out.println("user:" + user + ",userInfo:" + userInfo);
		/**
		 * 用户信息不能为空,且在数据库查询不到用户
		 */
		if(user == null && userInfo != null && !"null".equals(userInfo) && !"".equals(userInfo)){
			JSONObject jsonUser = new JSONObject().parseObject(userInfo);
			
			String path = null;
			try {
				//C://xxxxx/classes/static
				path = ResourceUtils.getURL("classpath:").getPath() + "/static";
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String relativePath =  "/user/icons/" + openid + ".jpg";
			String filePath = path + relativePath;
						
			/**
			 * 下载头像并保存至本地
			 */
			File file = restTemplate.execute(jsonUser.getString("avatarUrl"), HttpMethod.GET, null, clientHttpResponse -> {	
				
			    File ret = new File(filePath);
			    StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(ret));	
			    return ret;	
			});	
			
			/**
			 * 注册用户
			 */
			user = new User();
			user.setOpenid(openid);
			user.setNickname(jsonUser.getString("nickName"));
			user.setIcon(relativePath);
			userService.registerUser(user);
		}  
		
		
		/**
		 * 缓存用户的会话
		 */
		Map<String,Object> userSession = new HashMap<String,Object>();
		userSession.put("user",user);
		userSession.put("sessionKey",sessionKey);		//存储sessionKey
		
		//String wx_session_key = "wx_session_key:" + openid;
		
		/**
		 * 缓存微信会话,如果二次登陆会直接覆盖掉原来的会话的,缓存的key为openid,key的寿命是15分钟
		 */
		//redisTemplate.opsForHash().put("wx_session_key:", openid , userSession);		
		redisTemplate.opsForValue().set(sessionKey, userSession, 900000);
		
		System.out.println("response:" + resObject);
		/**
		 * 响应数据
		 */
		JSONObject response = new JSONObject();
		response.put("openid", openid);
		response.put("userInfo", user);
		response.put("session_key", sessionKey);
		
		return response.toJSONString();
	}


	@Override 
	public ResponseData wxLogout(String session_key) {
		boolean isLogout = redisTemplate.delete(session_key);
		System.out.println("注销成功:" + isLogout + ",sessionkey:" + session_key);
		return ResponseDataUtil.buildSuccess();
	}
	
}






