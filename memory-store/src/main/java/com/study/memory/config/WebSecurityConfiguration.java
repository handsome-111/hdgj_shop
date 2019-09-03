package com.study.memory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
/**
 * 认证
 * @author Administrator
 *
 */
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		/*
		 * 可以自定义加密方式
		 * 具体可参考:PasswordEncoderFactories.createDelegatingPasswordEncoder()
		  	encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
			encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
			encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
			encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
			encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
			encoders.put("scrypt", new SCryptPasswordEncoder());
			encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
			encoders.put("SHA-256", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
			encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
		*/
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasAuthority("SystemContent")
	        .antMatchers("/view/**").hasAuthority("SystemContentView")
	        .antMatchers("/insert/**").hasAuthority("SystemContentInsert")
	        .antMatchers("/update/**").hasAuthority("SystemContentUpdate")
	        .antMatchers("/delete/**").hasAuthority("SystemContentDelete");
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web.ignoring().antMatchers("/oauth/check_token");
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
			.withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
	}
}