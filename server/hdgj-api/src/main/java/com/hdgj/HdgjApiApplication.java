package com.hdgj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HdgjApiApplication {
	public static void main(String[] args) throws Exception {
		System.out.println(112); 
		SpringApplication.run(HdgjApiApplication.class, args);
	}

}
