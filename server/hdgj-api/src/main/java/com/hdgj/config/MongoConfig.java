package com.hdgj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;
	
	@Bean(name="mongoTransactionManager")
	MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
	  return new MongoTransactionManager(dbFactory);
	}

	@Override
	@Bean
	public MongoClient mongoClient() {
		MongoClientURI uri = new MongoClientURI(mongoUri);
		return new MongoClient(uri);
	}

	@Override
	protected String getDatabaseName() {
		String dataBase = mongoUri.substring(mongoUri.lastIndexOf("/") + 1);
		return dataBase;
	}
}

