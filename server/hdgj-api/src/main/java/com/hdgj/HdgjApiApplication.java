package com.hdgj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HdgjApiApplication {
	public static void main(String[] args) throws Exception {
		System.out.println(112); 
		SpringApplication.run(HdgjApiApplication.class, args);
	}

}
