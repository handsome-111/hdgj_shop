package com.hdgj.api.config;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.weidian.open.sdk.AbstractWeidianClient;
import com.weidian.open.sdk.DefaultWeidianClient;

@Configuration
public class ServerConfiguration {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${weidian.appkey}")
	private String appkey;
	
	@Value("${weidian.secret}")
	private String secret;

	
	@Bean	
    public RestTemplate restTemplate() {
		return new RestTemplate();
    }
		
	/**
	 * 获取微店客户端
	 * @return AbstractWeidianClient
	 */
	@Bean
	public AbstractWeidianClient vdClient(){
		return DefaultWeidianClient.getInstance();
	}
	
	/**
	 * 调用微店的各接口时都需使用access_token   
	 * @return access_token
	 * 
	 * access_token有效期为24小时，重复获取将导致上次获取的access_token在5分钟后失效                
	 * 每日获取access_token的api调用次数非常有限，建议开发者全局存储与更新access_token，避免频繁获取                
	 * 至少要为access_token字段保留512个字符空间
	 */
	@Bean
	public String vdAccessToken(){
		/**
		 * 微店获取token的url
		 */
		URIBuilder uri = new URIBuilder(); 
		uri.addParameter("grant_type", "client_credential");
		uri.addParameter("appkey",appkey);
		uri.addParameter("secret",secret);
		//https://oauth.open.weidian.com/token
		uri.setHost("oauth.open.weidian.com");
		uri.setPath("/token");
		uri.setScheme("https");
		String url = uri.toString();
		
		/**
		 * 1.发起请求
		 * 2.获取响应结果
		 * 3.判断是否有获取token
		 */
		String response = restTemplate.getForObject(url, String.class);		
		JSONObject responseObject = JSONObject.parseObject(response);
		
		//获取请求响应状态码
		String status_code = responseObject.getJSONObject("status").getString("status_code");		
		switch( status_code ){
			case "0":{
				return responseObject.getJSONObject("result").getString("access_token");
			}
		}
		return "";
	}
	
	
}
