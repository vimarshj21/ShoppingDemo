package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.service.ProductServiceImpl;

@SpringBootApplication
public class SpringBootShoppingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShoppingAppApplication.class, args);

	}

}
