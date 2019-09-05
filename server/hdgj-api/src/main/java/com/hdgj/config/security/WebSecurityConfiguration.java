package com.hdgj.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetails;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		/**
    		 * 配置授权
    		 */
    		.authorizeRequests()	
	    		.antMatchers("/static/**").permitAll()
	    		.antMatchers("/").permitAll()
	    		.antMatchers("/user/*").hasRole("USER")
	    		.antMatchers("/customer/*").hasRole("USER")
	    		.anyRequest().permitAll()		//其他请求都不需要认证
    		.and()
    		/**
    		 * 配置表单,如果调用以上需要权限的接口,则
    		 */
    		.formLogin() 
    			//.loginPage("/login")		//登录页面
    			//.failureUrl("/login-error")		
    			//.loginProcessingUrl("/authentication/form")				//自定义处理登录的请求,这时就不需要successForwardUrl了
    			//.successForwardUrl("/loginSuccess")
    			.and()
    		.exceptionHandling().accessDeniedPage("/401");		//异常处理重定向到401
    	
    	http.logout().logoutSuccessUrl("/");
    		
    	
    }
    
    /**
     * 认证管理器配置
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
    }
    
  

} 