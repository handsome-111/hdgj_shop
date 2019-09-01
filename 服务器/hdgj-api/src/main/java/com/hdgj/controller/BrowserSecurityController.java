package com.hdgj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowserSecurityController{
	
	private RequestCache requestCache  = new HttpSessionRequestCache();
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	/**
	 * 当需要身份认证时,跳转到这里
	 * @param request
	 * @param response
	 * @return
	 */
	
	@PostMapping("/authentication/require")
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public String requireAuthentication(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		System.out.println("开始登陆...");
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		if(savedRequest != null){
			String targetUrl = savedRequest.getRedirectUrl();
			System.out.println("转发的请求是:" + targetUrl);
			
			if(StringUtils.endsWithIgnoreCase(targetUrl, ".html")){
				redirectStrategy.sendRedirect(request, response, "MyHtml.html");
			}
			
		}
		
		return "访问的服务需要身份认证,请引导用户到登录界面";
		
	}
	
	
	@RequestMapping("/loginSuccess")
	public String success(){
		return "登录成功";
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
}
