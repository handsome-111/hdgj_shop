package com.hdgj;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HdgjApiApplication {
	public static void main(String[] args) throws Exception {
		System.out.println(12); 
		SpringApplication.run(HdgjApiApplication.class, args);
	}

}
