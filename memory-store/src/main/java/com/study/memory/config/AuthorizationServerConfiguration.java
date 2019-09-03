package com.study.memory.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 基于 JDBC 实现，需要事先在数据库配置客户端信息
	 * @return
	 */
	@Bean
	public ClientDetailsService jdbcClientDetails(){
		return new JdbcClientDetailsService(dataSource);
	}
	
	/**
	 * 基于 JDBC 实现，令牌保存到数据
	 * @return
	 */
	@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

	
	
	/**
	 * 授权,即获取授权码等
	 * 配置客户端,配置哪些客户端可以访问我这个认证服务器,把客户端信息保存到内存中演示
	 */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	// 读取客户端配置
    	clients.withClientDetails(jdbcClientDetails());
    }
    

    /**
     * 设置令牌
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	endpoints.tokenStore(tokenStore());
    }
}
