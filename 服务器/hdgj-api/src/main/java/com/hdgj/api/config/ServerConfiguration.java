package com.hdgj.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.weidian.open.sdk.AbstractWeidianClient;
import com.weidian.open.sdk.request.product.VdianItemGetRequest;

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
	
	@Bean
	public VdianItemGetRequest getWeidianClient(){
		String response = restTemplate.getForObject("https://oauth.open.weidian.com/token?grant_type=client_credential&appkey=xxx&secret=xxx", String.class);
		System.out.println(response);
		return new VdianItemGetRequest("", appkey);
	}
}
