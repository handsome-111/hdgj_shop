package com.hdgj.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

	/*// 声明bean
	@Bean(name = "hdgjDataSource")
	// 指明读取的配置
	@ConfigurationProperties(prefix = "spring.datasource.hdgj")
	// 设置为主数据源
	@Primary
	
	 * 声明数据源配置
	 
	public DataSource hdgjDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "hdgjSqlSessionFactory")
	@Primary
	*//**
	 * 使用声明的数据源，创建sqlSession工厂
	 *//*
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("hdgjDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		
		 * 当mybatis采用映射配置文件的方式时，指明该数据源需要是扫描的xml文件路径
		 
		bean.setDataSource(dataSource);
		
		 * bean.setMapperLocations( new
		 * PathMatchingResourcePatternResolver().getResources(
		 * "classpath:mybatis/mapper/test1/*.xml"));
		 
		return bean.getObject();
	}
	
    @Bean
    public TokenStore tokenStore() {
        // 基于 JDBC 实现，令牌保存到数据
        return new JdbcTokenStore(hdgjDataSource());
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
        return new JdbcClientDetailsService(hdgjDataSource());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 设置令牌
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 读取客户端配置
        clients.withClientDetails(jdbcClientDetails());
    }*/
}