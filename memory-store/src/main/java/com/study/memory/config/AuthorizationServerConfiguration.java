package com.study.memory.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// 声明bean
	@Bean(name="db1")
	// 指明读取的配置
	@ConfigurationProperties(prefix = "spring.datasource")
	// 设置为主数据源
	@Primary
	/*
	 * 声明数据源配置
	 */
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	private ClientDetailsService jdbcClientDetails(){
		return new JdbcClientDetailsService(dataSource());
	}
	
	/**
	 * 授权,即获取授权码等
	 * 配置客户端,配置哪些客户端可以访问我这个认证服务器,把客户端信息保存到内存中演示
	 */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	//配置客户端,使用的是JDBC
    	clients.withClientDetails(jdbcClientDetails());
    }
}
